package com.unicorn.article.controller;

import com.unicorn.article.pojo.Article;
import com.unicorn.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * 控制器层
 * @author wangsusheng
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
@Api(value = "ArticleController",description = "文章相关")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@ApiOperation(value="文章审核",notes = "文章审核")
	@RequestMapping(value = "/examine/{articleId}", method= RequestMethod.PUT)
	public Result examine(@PathVariable String articleId){
		articleService.examine(articleId);
		return new Result(true,StatusCode.OK,"审核成功");
	}
	@ApiOperation(value="文章点赞",notes = "文章点赞")
	@RequestMapping(value = "/thumbup/{articleId}", method= RequestMethod.PUT)
	public Result updateThumbup(@PathVariable String articleId){
		articleService.updateThumbup(articleId);
		return new Result(true,StatusCode.OK,"点赞成功");
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@ApiOperation(value="查询全部文章",notes = "查询全部文章")
	@RequestMapping(value = "/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",articleService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@ApiOperation(value="根据ID查询文章",notes = "根据ID查询文章")
	@RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",articleService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@ApiOperation(value="分页+多条件查询文章",notes = "分页+多条件查询文章")
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Article> pageList = articleService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Article>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
	@ApiOperation(value="根据条件查询文章",notes = "根据条件查询文章")
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param article
	 */
	@ApiOperation(value="增加文章",notes = "增加文章")
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public Result add(@RequestBody Article article  ){
		articleService.add(article);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param article
	 */
	@ApiOperation(value="修改文章",notes = "修改文章")
	@RequestMapping(value="/update/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Article article, @PathVariable String id ){
		article.setId(id);
		articleService.update(article);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@ApiOperation(value="删除文章",notes = "删除文章")
	@RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		articleService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
