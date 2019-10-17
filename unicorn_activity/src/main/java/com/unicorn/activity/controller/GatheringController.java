package com.unicorn.activity.controller;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/17 19:29
 */

import com.unicorn.activity.pojo.Gathering;
import com.unicorn.activity.service.GatheringService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/activity")
@Api(value = "GatheringController",description = "活动相关")
public class GatheringController {
    @Autowired
    private GatheringService gatheringService;


    /**
     * 查询全部数据
     * @return
     */
    @ApiOperation(value = "查询全部活动数据",notes = "查询全部活动数据")
    @RequestMapping(value = "/findAll",method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",gatheringService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @ApiOperation(value = "根据ID查询活动",notes = "根据ID查询活动")
    @RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",gatheringService.findById(id));
    }


    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @ApiOperation(value = "分页+多条件查询活动",notes = "分页+多条件查询活动")
    @RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
        Page<Gathering> pageList = gatheringService.findSearch(searchMap, page, size);
        return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Gathering>(pageList.getTotalElements(), pageList.getContent()) );
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @ApiOperation(value = "根据条件查询活动",notes = "根据条件查询活动")
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",gatheringService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param gathering
     */
    @ApiOperation(value = "增加活动",notes = "增加活动")
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public Result add(@RequestBody Gathering gathering  ){
        gatheringService.add(gathering);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    /**
     * 修改
     * @param gathering
     */
    @ApiOperation(value = "修改活动",notes = "修改活动")
    @RequestMapping(value="/update/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Gathering gathering, @PathVariable String id ){
        gathering.setId(id);
        gatheringService.update(gathering);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @ApiOperation(value = "删除活动",notes = "删除活动")
    @RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        gatheringService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }


}
