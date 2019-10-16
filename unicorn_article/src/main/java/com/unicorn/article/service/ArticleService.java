package com.unicorn.article.service;

import com.unicorn.article.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 11:49
 */
public interface ArticleService {

    void examine(String id);

    void updateThumbup(String id);

    /**
     * 查询全部列表
     *
     * @return
     */
    List<Article> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Article> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Article> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Article findById(String id);

    /**
     * 增加
     *
     * @param article
     */
    void add(Article article);

    /**
     * 修改
     *
     * @param article
     */
    void update(Article article);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);
}
