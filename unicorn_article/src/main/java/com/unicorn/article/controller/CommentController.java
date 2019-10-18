package com.unicorn.article.controller;

import com.unicorn.article.pojo.Comment;
import com.unicorn.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 14:56
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
@Api(value = "public class CommentController", description = "文章评论相关")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "新增评论", notes = "新增评论")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "新增评论成功");
    }

    @ApiOperation(value = "查看文章所有评论", notes = "查看文章所有评论")
    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.POST)
    public Result findByArticleid(@PathVariable String articleid) {

        return new Result(true, StatusCode.OK, "查询评论成功", commentService.findByArticleid(articleid));
    }

    @ApiOperation(value = "删除评论", notes = "删除评论")
    @RequestMapping(value = "/delete/{commentid}", method = RequestMethod.POST)
    public Result delete(@PathVariable String commentid) {
        commentService.delete(commentid);
        return new Result(true, StatusCode.OK, "新增评论成功");
    }

}
