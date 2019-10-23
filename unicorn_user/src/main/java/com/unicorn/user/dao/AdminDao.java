package com.unicorn.user.dao;

import com.unicorn.user.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/22 14:59
 */
public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {

    @Query(value = "select * FROM tb_admin  where username=? ", nativeQuery = true)
    public Admin findByLoginname(String username);
}
