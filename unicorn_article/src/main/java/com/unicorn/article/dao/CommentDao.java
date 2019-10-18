package com.unicorn.article.dao;

import com.unicorn.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论Dao
 * @Author:wangsusheng
 * @Date: 2019/10/18 14:47
 */
public interface CommentDao extends MongoRepository<Comment,String> {
     List<Comment> findByArticleid(String articleid);
}
