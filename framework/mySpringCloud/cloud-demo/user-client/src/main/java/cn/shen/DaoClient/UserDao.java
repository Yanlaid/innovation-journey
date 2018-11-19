package cn.shen.DaoClient;

import cn.shen.pojoClient.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "queryUsersByIdsDefaultFallback")
    public User queryUsersByIds(Long id) {
        String baseUrl = "http://user-service/hello/hello1/";
        return restTemplate.getForObject(baseUrl + id, User.class);

    }

    /**
     * TODO
     * hyxtris熔断器的回调方法
     *
     * @param ids
     * @return
     */
    public User queryUsersByIdsDefaultFallback(Long ids) {
        User user = new User();
        user.setName("用户查询失败，此时为Hystrix熔断器方法");
        return user;
    }
}
