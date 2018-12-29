package com.tensquare.friend.web.controller;

import com.tensquare.friend.service.FriendService;
import constants.StatusCode;
import dto.ResultDTO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 添加好友
     *
     * @param friendid 对方用户ID
     * @param type     1：喜欢 0：不喜欢
     * @return
     */
    @PutMapping("/like/{friendid}/{type}")
    public ResultDTO add(@PathVariable String friendid, @PathVariable String type) {
        //获取当前登录人的信息
        Claims claims = (Claims) request.getAttribute("user_claims");
        //判断是否能获取到
        if (claims == null) {
            return new ResultDTO(false, StatusCode.ACCESSERROR, "无权访问，请先登录");
        }
       //判断是否是喜欢
        if (type.equals("1")) {
            //如果是喜欢，要添加好友
            if (friendService.saveFriend(claims.getId(), friendid) == 0) {
                return new ResultDTO(false, StatusCode.REPERROR, "已经添加过此好友");
            }
        } else {
            //不喜欢
        }
        return new ResultDTO(true, StatusCode.OK, "操作成功");
    }
}