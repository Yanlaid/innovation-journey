package cn.shen.travleIntegration.service.impl;

import cn.shen.travleIntegration.exception.UserExistsException;
import cn.shen.travleIntegration.exception.UserNameOrPasswordErrorException;
import cn.shen.travleIntegration.exception.UserNoActiveException;
import cn.shen.travleIntegration.mapper.UserMapper;
import cn.shen.travleIntegration.pojo.User;
import cn.shen.travleIntegration.service.IUserService;
import cn.shen.travleIntegration.utils.MailUtil;
import cn.shen.travleIntegration.utils.Md5Util;
import cn.shen.travleIntegration.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * <p>Title:      注册用户. </p>
     * <p>Description TODO</p>
     *
     * @param user
     * @return void
     * @Author 沈欣然
     * @CreateDate 2018/10/13 7:33
     */
    @Override
    public void register(User user) throws Exception {
        //    判断用户是否已经存在于数据库
        User isUser = userMapper.queryUserByUserName(user.getUsername());
        if (isUser != null) {
            throw new UserExistsException("用户名已存在");
        }
        //    到这里表示用户可以注册
        //    设置用户激活状态
        user.setStatus("N");
        //    设置激活码
        user.setCode(UuidUtil.getUuid());
        //    加密用户密码
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        //    发送邮箱验证码
        MailUtil.sendMail(user.getEmail(),"<a href='http://localhost:8080/user/active?code="+user.getCode()+"'>TravelRegister</a>");
        userMapper.register(user);
    }

    @Override
    public Boolean active(String code) {
        int i = userMapper.active(code);
        return i==1;
    }

    @Override
    public User login(User user) throws Exception {
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        User queryUser = userMapper.queryLoginUser(user);
    //    用户名密码错误
        if(queryUser==null){
            throw new UserNameOrPasswordErrorException("用户名密码错误");
        }
        if(queryUser.getStatus().equals('N')){
            throw new UserNoActiveException("用户未激活");
        }
        return queryUser;
    }
}
