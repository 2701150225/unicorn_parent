package com.unicorn.activity.service;

import com.unicorn.activity.pojo.Gathering;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/17 19:19
 */
public interface GatheringService  {
    /**
     * 查询全部列表
     *
     * @return
     */

    List<Gathering> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Gathering> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Gathering> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     * @Cacheable 添加缓存 value属性表示缓存整体唯一标识,key属性标识缓存键值对中的key
     */

    Gathering findById(String id);

    /**
     * 增加
     *
     * @param gathering
     */
    void add(Gathering gathering);

    /**
     * 修改
     *
     * @param gathering
     */

    void update(Gathering gathering);

    /**
     * 删除
     *
     * @param id
     */

    void deleteById(String id);
}
