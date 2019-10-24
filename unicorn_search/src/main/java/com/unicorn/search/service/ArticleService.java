package com.unicorn.search.service;

import com.unicorn.search.dao.ArticleDao;
import com.unicorn.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void save(Article article){
        //article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }

    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return articleDao.findByTitleOrContentLike(key, key, pageable);
    }
}
