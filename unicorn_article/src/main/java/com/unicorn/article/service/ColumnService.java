package com.unicorn.article.service;

import com.unicorn.article.pojo.Column;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 11:50
 */
public interface ColumnService {

    /**
     * 查询全部列表
     *
     * @return
     */
    List<Column> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Column> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Column> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Column findById(String id);

    /**
     * 增加
     *
     * @param column
     */
    void add(Column column);

    /**
     * 修改
     *
     * @param column
     */
    void update(Column column);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);
}
