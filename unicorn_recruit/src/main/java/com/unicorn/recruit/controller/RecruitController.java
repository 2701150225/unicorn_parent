package com.unicorn.recruit.controller;

import com.unicorn.recruit.pojo.Enterprise;
import com.unicorn.recruit.pojo.Recruit;
import com.unicorn.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 17:06
 */

@RestController
@CrossOrigin
@RequestMapping("/recruit")
@Api(value = "RecruitController",description = "招聘相关")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;
    @ApiOperation(value="查询推荐职位列表",notes = "查询推荐职位列表")
    @RequestMapping(value = "/search/recommend",method= RequestMethod.GET)
    public Result recommend(){
        List<Recruit> list = recruitService.findTop6ByStateOrderByCreatetime();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @ApiOperation(value="查询最新职位列表",notes = "查询最新职位列表")
    @RequestMapping(value = "/search/newlist",method= RequestMethod.GET)
    public Result newlist(){
        List<Recruit> list = recruitService.findTop6ByStateNotOrderByCreatetimeDesc();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation(value="查询全部职位",notes = "查询全部职位")

    @RequestMapping(value = "/findAll",method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @ApiOperation(value="查询职位详情",notes = "查询职位详情")
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.findById(id));
    }


    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @ApiOperation(value="分页+多条件查询职位",notes = "分页+多条件查询职位")
    @RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
        Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Recruit>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @ApiOperation(value="根据条件查询职位",notes = "根据条件查询职位")
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",recruitService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param recruit
     */
    @ApiOperation(value="增加职位",notes = "增加职位")
    @RequestMapping(value = "add",method=RequestMethod.POST)
    public Result add(@RequestBody Recruit recruit  ){
        recruitService.add(recruit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param recruit
     */
    @ApiOperation(value="修改职位",notes = "修改职位")
    @RequestMapping(value="/update/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Recruit recruit, @PathVariable String id ){
        recruit.setId(id);
        recruitService.update(recruit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @ApiOperation(value="删除职位",notes = "删除职位")
    @RequestMapping(value="delete/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        recruitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }


}


