package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO findAll() {

        return new ResultDTO(true, 1000, "查询成功", userService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDTO findById(@PathVariable String id) {
        return new ResultDTO(true, 1000, "查询成功", userService.findById(id));
    }


    /**
     * 分页查询全部数据
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public ResultDTO findPage(@PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findPage(page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<User>(pageList.getTotalElements(), pageList.getContent()));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.POST)
    public ResultDTO findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<User>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     *
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO add(@RequestBody User user) {
        userService.add(user);
        return new ResultDTO(true, 1000, "增加成功");
    }

    /**
     * 修改
     *
     * @param user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultDTO update(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return new ResultDTO(true, 1000, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDTO delete(@PathVariable String id) {
//        先鉴权，判断是否是管理员
        //1.先鉴权，必须是管理员角色才能删除用户
        //获取头信息，约定头信息key为Authorization
       /* String authorizationHeader = request.getHeader("JwtAuthorization");
        //判断是否为空
        if(null == authorizationHeader){
            return new ResultDTO(false,StatusCode.ACCESSERROR,"权限不足1");
        }
        //判断授权头信息中是否是以“Bearer ”开头
        if(!authorizationHeader.startsWith("Bearer ")){
            return new ResultDTO(false,StatusCode.ACCESSERROR,"权限不足2");
        }

        //获取载荷
        Claims claims =null;
        try {
            //获取令牌
            String token=authorizationHeader.substring(7);
            claims = jwtUtil.parseJWT(token);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDTO(false,StatusCode.ACCESSERROR,"权限不足3");
        }

        //判断载荷是否为空
        if(null == claims){
            return new ResultDTO(false,StatusCode.ACCESSERROR,"权限不足4");
        }
        //判断令牌中的自定义载荷中的角色是否是admin
        if(!"admin".equals(claims.get("roles"))){
            return new ResultDTO(false,StatusCode.ACCESSERROR,"权限不足5");
        }*/
        Claims admin_claims = (Claims) request.getAttribute("admin_claims");
        if (admin_claims == null) {
            return new ResultDTO(false, StatusCode.ACCESSERROR, "权限不足");
        }
        /**
         * 最终执行删除
         */
        userService.deleteById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 用户注册
     *
     * @param user
     */
    @PostMapping("/register/{checkcode}")
    public ResultDTO register(@RequestBody User user, @PathVariable String checkcode) {
        userService.saveUser(user, checkcode);
        return new ResultDTO(true, StatusCode.OK, "用户注册成功");
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ResultDTO login(@RequestBody Map mapValue) {
        User user = userService.login(mapValue);
        if (!(null == user)) {
            String token = jwtUtil.createJWT(user.getId(), user.getNickname(), "user");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("name", user.getNickname());
            map.put("avatar", user.getAvatar());
            return new ResultDTO(true, StatusCode.OK, "登录成功", map);
        }
        return new ResultDTO(true, StatusCode.LOGINERROR, "用户名或者密码错误");
    }
}
