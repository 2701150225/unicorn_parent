package com.unicorn.user.service;

import com.unicorn.user.pojo.Admin;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/22 14:59
 */
public interface AdminService {

    public Admin login(Admin admin);

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Admin> findAll();


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Admin> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Admin> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Admin findById(String id);

    /**
     * 增加
     *
     * @param admin
     */
    public void add(Admin admin);

    /**
     * 修改
     *
     * @param admin
     */
    public void update(Admin admin);

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id);
}
