package com.unicorn.user.dao;

import com.unicorn.user.pojo.Admin;
import com.unicorn.user.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 16:38
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    public User findByMobile(String mobile);

	@Modifying
	@Query(value = "update tb_user set fanscount=fanscount+? where id=?", nativeQuery = true)
    public void updatefanscount(int x, String friendid);

    @Modifying
    @Query(value = "update tb_user set followcount=followcount+? where id=?", nativeQuery = true)
    public void updatefollowcount(int x, String userid);

    @Modifying
    @Query(value = "update  tb_user set lastdate=?1,loginip=?2  where mobile=?3", nativeQuery = true)
    public void updateUser(Date lastdate, String loginip, String mobile);


}
