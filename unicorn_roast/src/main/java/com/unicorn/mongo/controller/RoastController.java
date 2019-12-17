package com.unicorn.mongo.controller;

import com.unicorn.mongo.pojo.Roast;
import com.unicorn.mongo.service.RoastService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 11:14
 */

@RestController
@RequestMapping("/roast")
@CrossOrigin
@Api(value = "RoastController",description = "吐槽大会相关")
public class RoastController {

    @Autowired
    private RoastService roastService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value="查询所有吐槽内容",notes = "查询所有吐槽内容")
    @RequestMapping(value="/findAll",method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", roastService.findAll());
    }

    @ApiOperation(value="根据ID查询吐槽内容",notes = "根据ID查询吐槽内容")
    @RequestMapping(value = "/findById/{roastId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String roastId){
        return new Result(true, StatusCode.OK, "查询成功", roastService.findById(roastId));
    }

    @ApiOperation(value="新增吐槽",notes = "新增吐槽")
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result save(@RequestBody Roast roast){
        roastService.save(roast);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @ApiOperation(value="编辑吐槽",notes = "编辑吐槽")
    @RequestMapping(value = "/update/{roastId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String roastId, @RequestBody Roast roast){
        roast.set_id(roastId);
        roastService.update(roast);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @ApiOperation(value="删除吐槽",notes = "删除吐槽")
    @RequestMapping(value = "/delete/{roastId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String roastId){
        roastService.deleteById(roastId);
        return new Result(true, StatusCode.OK, "删除成功");
    }
    @ApiOperation(value="根据上级ID查询吐槽分页数据 ",notes = "根据上级ID查询吐槽分页数据 ")
    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result comment(@PathVariable String parentid, @PathVariable int page, @PathVariable int size){

        Page<Roast> pageData = roastService.pageQuery(parentid, page, size);

        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Roast>(pageData.getTotalElements(), pageData.getContent()));
    }

    @ApiOperation(value="点赞",notes = "点赞")
    @RequestMapping(value = "/thumbup/{roastId}", method = RequestMethod.PUT)
    public Result addthumbup(@PathVariable String roastId){
        String userid = "11111";
        //先判断该用户是否已经点赞了。
        if(redisTemplate.opsForValue().get("roast_"+userid+"_"+roastId)!=null){
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        roastService.addthumbup(roastId);

        redisTemplate.opsForValue().set("roast_"+userid+"_"+roastId, 1);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

}
