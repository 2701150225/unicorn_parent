package com.unicorn.article.service;

import com.unicorn.article.pojo.Channel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 11:50
 */
public interface ChannelService {


    /**
     * 查询全部列表
     *
     * @return
     */
    List<Channel> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Channel> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Channel> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Channel findById(String id);

    /**
     * 增加
     *
     * @param channel
     */
    void add(Channel channel);

    /**
     * 修改
     *
     * @param channel
     */
    void update(Channel channel);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);
}
