package com.unicorn.search.controller;

import com.unicorn.search.pojo.Article;
import com.unicorn.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */

@RestController
@RequestMapping("/article")
@CrossOrigin
@Api(value = "ArticleController",description = "文章搜索相关")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{key}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size){
        Page<Article> pageData = articleService.findByKey(key, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(pageData.getTotalElements(), pageData.getContent()));
    }
}
