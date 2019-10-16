package com.unicorn.article.controller;
import java.util.Map;

import com.unicorn.article.pojo.Channel;
import com.unicorn.article.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author wangsusheng
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/channel")
@Api(value = "ChannelController",description = "频道相关")
public class ChannelController {

	@Autowired
	private
	ChannelService channelService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@ApiOperation(value="查询全部频道数据",notes = "查询全部频道数据")
	@RequestMapping(value = "/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",channelService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@ApiOperation(value="根据ID查询频道",notes = "根据ID查询频道")
	@RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",channelService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@ApiOperation(value="分页+多条件查询频道",notes = "分页+多条件查询频道")
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Channel> pageList = channelService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Channel>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
	@ApiOperation(value="根据条件查询频道",notes = "根据条件查询频道")
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",channelService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param channel
	 */
	@ApiOperation(value="增加频道",notes = "增加频道")
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public Result add(@RequestBody Channel channel  ){
		channelService.add(channel);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param channel
	 */
	@ApiOperation(value="修改频道",notes = "修改频道")
	@RequestMapping(value="/update/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Channel channel, @PathVariable String id ){
		channel.setId(id);
		channelService.update(channel);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@ApiOperation(value="删除频道",notes = "删除频道")
	@RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		channelService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
