package com.unicorn.article.service;

import com.unicorn.article.pojo.Comment;

import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 14:50
 */
public interface CommentService {

    void add(Comment comment);

    List<Comment> findByArticleid(String articleid);

    void delete(String  commentid);
}
