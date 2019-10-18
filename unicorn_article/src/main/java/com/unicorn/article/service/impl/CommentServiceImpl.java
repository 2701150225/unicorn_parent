package com.unicorn.article.service.impl;

import com.unicorn.article.dao.CommentDao;
import com.unicorn.article.pojo.Comment;
import com.unicorn.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdUtil;

import java.util.Date;
import java.util.List;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 14:50
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private IdUtil idUtil;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Comment comment) {
        comment.set_id(idUtil.nextId() + "");
        //初始化数据完善
        comment.setPublishdate(new Date());//发布日期
        //判断当前评论是否有父节点
        if (comment.getParentid() != null && !"".equals(comment.getParentid())) {
            //给父节点评论的回复数加一
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(comment.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "comment");
        }
        commentDao.save(comment);
    }

    @Override
    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }

    @Override
    public void delete(String commentid) {
        commentDao.deleteById(commentid);
    }
}
