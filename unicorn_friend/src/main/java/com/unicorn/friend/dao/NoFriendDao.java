package com.unicorn.friend.dao;

import com.unicorn.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Author:wangsusheng
 * @Date: 2019/10/25 15:31
 */
public interface NoFriendDao extends JpaRepository<NoFriend, String> {
    public NoFriend findByUseridAndFriendid(String userid, String friendid);
}
