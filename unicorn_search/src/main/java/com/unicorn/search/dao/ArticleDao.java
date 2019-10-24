package com.unicorn.search.dao;

import com.unicorn.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 11:38
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
