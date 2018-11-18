package cn.shen.controller;

import cn.shen.pojo.User;
import cn.shen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("users")
    public String queryUserList(Model model) {
        List<User> userList = userService.queryUserList();
        model.addAttribute("userList", userList);
        return "users";
    }
    @RequestMapping("deleteUserById")
    public String deleteUserById(@RequestParam("id")Long id){
        userService.deleteUserById(id);
        return "redirect:users";
    }
}
