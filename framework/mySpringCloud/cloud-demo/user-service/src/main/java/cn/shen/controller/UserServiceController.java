package cn.shen.controller;

import cn.shen.pojo.User;
import cn.shen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("hello")
public class UserServiceController {
    @Autowired
    private UserService userService;

    @GetMapping("hello1/{id}")
    public User getq(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(new Random().nextInt(2000));
        return userService.queryById(id);
    }
}
