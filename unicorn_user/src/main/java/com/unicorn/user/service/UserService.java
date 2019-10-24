package com.unicorn.user.service;

import com.unicorn.user.pojo.User;
import entity.Result;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 17:01
 */
public interface UserService {

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<User> findSearch(Map whereMap, int page, int size);


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<User> findSearch(Map whereMap);

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public User findById(String id);

    /**
     * 增加
     *
     * @param user
     */
    public void add(User user,String code);

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user);

    /**
     * 删除 必须有admin角色才能删除
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 发送短信
     * @param mobile
     */
    Result sendSms(String mobile);

    User login(String mobile, String password);

    void   updateUser(Date lastdate,String  loginip,String mobile);
}
