package com.unicorn.recruit.service;

import com.unicorn.recruit.pojo.Enterprise;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 17:03
 */
public interface EnterpriseService {

    List<Enterprise> hotList();

    /**
     * 查询全部列表
     *
     * @return
     */
    List<Enterprise> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Enterprise> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Enterprise> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Enterprise findById(String id);

    /**
     * 增加
     *
     * @param enterprise
     */
    void add(Enterprise enterprise);

    /**
     * 修改
     *
     * @param enterprise
     */
    void update(Enterprise enterprise);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);
}
