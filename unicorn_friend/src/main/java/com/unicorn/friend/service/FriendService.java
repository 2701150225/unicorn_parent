package com.unicorn.friend.service;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/25 16:39
 */
public interface FriendService {
    public int addFriend(String userid, String friendid) ;
    public int addNoFriend(String userid, String friendid);
    public void deleteFriend(String userid, String friendid);
}
