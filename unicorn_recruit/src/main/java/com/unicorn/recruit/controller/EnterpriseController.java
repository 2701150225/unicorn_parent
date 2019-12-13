package com.unicorn.recruit.controller;

import com.unicorn.recruit.pojo.Enterprise;
import com.unicorn.recruit.service.EnterpriseService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 17:19
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
@Api(value = "EnterpriseController",description = "企业信息相关")
public class EnterpriseController {


    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation(value = "查询热门企业",notes = "查询热门企业")
    @RequestMapping(value = "/search/hotlist", method= RequestMethod.GET)
    public Result hotlist(){
        List<Enterprise> list = enterpriseService.hotList();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation(value = "查询全部企业",notes = "查询全部企业")
    @RequestMapping(value = "/findAll",method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @ApiOperation(value = "根据ID查询企业",notes = "根据ID查询企业")
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findById(id));
    }


    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @ApiOperation(value = "分页+多条件查询企业",notes = "分页+多条件查询企业")
    @RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
        Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);

        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Enterprise>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @ApiOperation(value = "根据条件查询企业",notes = "根据条件查询企业")
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",enterpriseService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param enterprise
     */
    @ApiOperation(value = "增加企业",notes = "增加企业")
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public Result add(@RequestBody Enterprise enterprise  ){
        enterpriseService.add(enterprise);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param enterprise
     */
    @ApiOperation(value = "修改企业",notes = "修改企业")
    @RequestMapping(value="/update/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Enterprise enterprise, @PathVariable String id ){
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /**
     * 删除
     * @param id
     */
    @ApiOperation(value = "删除企业",notes = "删除企业")
    @RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        enterpriseService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
