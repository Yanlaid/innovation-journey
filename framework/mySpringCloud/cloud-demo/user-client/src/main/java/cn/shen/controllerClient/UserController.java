package cn.shen.controllerClient;

import cn.shen.pojoClient.User;
import cn.shen.serviceClient.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserClientService userClientService;

    @GetMapping("user")
    public List<User> queryUsersByIds(@RequestParam("ids") List<Long> ids) {
        return userClientService.queryUsersByIds(ids);
    }
}

