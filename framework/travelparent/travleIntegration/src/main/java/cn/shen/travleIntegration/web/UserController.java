package cn.shen.travleIntegration.web;

import cn.shen.travleIntegration.exception.UserExistsException;
import cn.shen.travleIntegration.exception.UserNameOrPasswordErrorException;
import cn.shen.travleIntegration.exception.UserNoActiveException;
import cn.shen.travleIntegration.pojo.ResultInfo;
import cn.shen.travleIntegration.pojo.User;
import cn.shen.travleIntegration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    @ResponseBody
    public ResultInfo register(@RequestParam("check") String code, User user, HttpSession session) {
        ResultInfo resultInfo;
        try {
            //校验验证码
            String ServiceCode = (String) session.getAttribute("check");
            if (!code.equalsIgnoreCase(ServiceCode)) {
                resultInfo = new ResultInfo(false, null, "验证码错误");
            } else {
                userService.register(user);
                resultInfo = new ResultInfo(true, null, null);
            }
        } catch (UserExistsException e) {
            resultInfo = new ResultInfo(false, null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "服务器繁忙，请稍后刷新重试");
        }
        return resultInfo;
    }

    @RequestMapping("active")
    public String active(@RequestParam("code") String code) {
        try {
            Boolean flag = userService.active(code);
            if (flag) {
                return "redirect:/login.html";
            } else {
                return "redirect:/error/500.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error/500.html";
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(@RequestParam("check") String code, User user, HttpSession session) {
        ResultInfo resultInfo;
        try {
            if (!code.equalsIgnoreCase((String) session.getAttribute("check"))) {
                resultInfo = new ResultInfo(false, null, "验证码错误");
            } else {
                User login = userService.login(user);
                resultInfo = new ResultInfo(true, null, null);
                session.setAttribute("userInfo",user);
            }
        } catch (UserNameOrPasswordErrorException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "用户名或者密码错误");
        } catch (UserNoActiveException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "用户未激活");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "系统错误，请稍后重试");
        }
        return resultInfo;
    }
    @RequestMapping("getHeaderinformation")
    @ResponseBody
    public ResultInfo getHeaderinformation(HttpSession session){
        ResultInfo resultInfo;
        User userInfo = (User) session.getAttribute("userInfo");
        if(userInfo!=null){
            resultInfo = new ResultInfo(true, userInfo.getUsername(), null);
        }else {
            resultInfo = new ResultInfo(false);
        }
        return resultInfo;
    }
    @RequestMapping("quit")
    public String quit(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
