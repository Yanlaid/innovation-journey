package com.tensquare.friend.dao;

import com.tensquare.friend.po.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, String> {

    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    int findCountByUseridAndFriendid(String userId, String friendId);

    int countByUseridAndFriendid(String userId, String friendId);

    @Modifying
    @Query("update Friend f set f.islike=?3 where f.friendid=?2 and f.userid=?1")
    void updateIslikeByUseridAndFriendid(String userId, String friendId, String isLike);
}
