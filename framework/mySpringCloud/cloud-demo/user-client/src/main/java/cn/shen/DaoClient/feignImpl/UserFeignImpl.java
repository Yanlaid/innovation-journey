package cn.shen.DaoClient.feignImpl;

import cn.shen.DaoClient.UserFeign;
import cn.shen.pojoClient.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignImpl implements UserFeign {
    @Override
    public User getq(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("这是feign下的Hystrix的熔断器配置");
        return user;
    }
}
