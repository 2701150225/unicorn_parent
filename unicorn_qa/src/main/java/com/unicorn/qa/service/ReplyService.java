package com.unicorn.qa.service;

import com.unicorn.qa.pojo.Reply;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/16 10:25
 */
public interface ReplyService {

    /**
     * 查询全部列表
     *
     * @return
     */
    List<Reply> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Reply> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Reply> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Reply findById(String id);

    /**
     * 增加
     *
     * @param reply
     */
    void add(Reply reply);

    /**
     * 修改
     *
     * @param reply
     */
    void update(Reply reply);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);


}
