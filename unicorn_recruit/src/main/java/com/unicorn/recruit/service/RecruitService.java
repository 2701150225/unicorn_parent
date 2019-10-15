package com.unicorn.recruit.service;

import com.unicorn.recruit.pojo.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 17:04
 */
@Service
public interface RecruitService {

    List<Recruit> findTop6ByStateOrderByCreatetime();


    List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc();

    /**
     * 查询全部列表
     *
     * @return
     */
    List<Recruit> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    Page<Recruit> findSearch(Map whereMap, int page, int size);

    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    List<Recruit> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    Recruit findById(String id);

    /**
     * 增加
     *
     * @param recruit
     */
    void add(Recruit recruit);

    /**
     * 修改
     *
     * @param recruit
     */
    void update(Recruit recruit);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);


}