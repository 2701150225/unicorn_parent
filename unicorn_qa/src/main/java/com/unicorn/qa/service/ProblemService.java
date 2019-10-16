package com.unicorn.qa.service;

import com.unicorn.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 10:08
 */
public interface ProblemService {
    /**
     * 分页查询最新问答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem> newlist(String labelid, int page, int size);

    /**
     * 分页查询最热问答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem> hotlist(String labelid, int page, int size);

    /**
     * 分页查询等待回答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    Page<Problem> waitlist(String labelid, int page, int size);


    /**
     * 查询全部列表
     *
     * @return
     */
    List<Problem> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Problem> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Problem> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Problem findById(String id);

    /**
     * 增加
     *
     * @param problem
     */
    void add(Problem problem);

    /**
     * 修改
     *
     * @param problem
     */
    void update(Problem problem);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);

}
