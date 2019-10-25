package com.unicorn.friend.service.impl;

import com.unicorn.friend.dao.FriendDao;
import com.unicorn.friend.dao.NoFriendDao;
import com.unicorn.friend.pojo.Friend;
import com.unicorn.friend.pojo.NoFriend;
import com.unicorn.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/25 16:36
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userid, String friendid) {
        //先判断userid到friendid是否有数据，有就是重复添加好友，返回0
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
        if(friend!=null){
            return 0;
        }
        //直接添加好友，让好友表中userid到friendid方向的type为0
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        //判断从friendid到userid是否有数据，如果有，把双方的状态都改为1
        if(friendDao.findByUseridAndFriendid(friendid, userid)!=null){
            //把双方的islike都改成1
            friendDao.updateIslike("1", userid, friendid);
            friendDao.updateIslike("1", friendid, userid);
        }
        return 1;
    }

    public int addNoFriend(String userid, String friendid) {
        //先判断是否已经是非好友
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        if(noFriend!=null){
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        //删除还有表中userid到friendid这条数据
        friendDao.deletefriend(userid, friendid);
        //更新friendid到userid的islike为0
        friendDao.updateIslike("0", friendid, userid);
        //非好友表中添加数据
        NoFriend nofriend = new NoFriend();
        nofriend.setUserid(userid);
        nofriend.setFriendid(friendid);
        noFriendDao.save(nofriend);
    }
}
