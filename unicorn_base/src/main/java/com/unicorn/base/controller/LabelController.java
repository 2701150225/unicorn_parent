package com.unicorn.base.controller;

import com.unicorn.base.pojo.Label;
import com.unicorn.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:48
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
@Api(value = "LabelController",description = "标签相关")
public class LabelController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private HttpServletRequest request;
//    @Value("${ip}")
//    private String ip;

    @ApiOperation(value = "新增标签",notes = "新增标签")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,  "保存成功");
    }

    @ApiOperation(value = "查询全部列表",notes = "查询全部列表")
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Result findAll(){
  //      System.out.println("ip为："+ip);
        //获取头信息
        String header = request.getHeader("Authorization");
        System.out.println(header);

        List<Label> list = labelService.findAll();
        return new Result(true,StatusCode.OK,  "查询成功", list);
    }

    @ApiOperation(value = "根据ID查询标签",notes = "根据ID查询标签")
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String id){
        System.out.println("222222222222222");
        Label label = labelService.findById(id);
        return new Result(true,StatusCode.OK, "查询成功", label);
    }

    @ApiOperation(value = "修改标签",notes = "修改标签")
    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,  "修改成功");
    }

    @ApiOperation(value = "删除标签",notes = "删除标签")
    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true,StatusCode.OK,  "删除成功");
    }

    @ApiOperation(value = "查询标签",notes = "查询标签")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,  "查询成功", list);
    }

    @ApiOperation(value = "分页查询",notes = "分页查询")
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody Label label){
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true,StatusCode.OK, "查询成功",
                new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}
