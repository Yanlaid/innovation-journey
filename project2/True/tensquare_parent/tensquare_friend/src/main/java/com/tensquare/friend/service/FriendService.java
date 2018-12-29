package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendRepository;
import com.tensquare.friend.po.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

    /**
     * 保存好友
     * @param userid
     * @param friendid
     * @return
     */
    @Transactional
    public int saveFriend(String userid, String friendid) {
        //判断如果用户已经添加了这个好友，则不进行任何操作,返回0
        if (friendRepository.findCountByUseridAndFriendid(userid, friendid) > 0) {
            return 0;
        }
        //向好友表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendRepository.save(friend);
        //判断对方是否喜欢你，如果喜欢，将islike设置为1
        //判断对方是否已经添加你为好友，如果是，则修改互粉状态。聊天通道打开。
        if (friendRepository.findCountByUseridAndFriendid(friendid, userid) > 0) {
            friendRepository.updateIslikeByUseridAndFriendid(userid, friendid, "1");
            friendRepository.updateIslikeByUseridAndFriendid(friendid, userid, "1");
        }

        //正常添加了
        return 1;
    }
}