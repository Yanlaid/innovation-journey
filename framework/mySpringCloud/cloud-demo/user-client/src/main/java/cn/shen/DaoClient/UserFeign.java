package cn.shen.DaoClient;

import cn.shen.DaoClient.feignImpl.UserFeignImpl;
import cn.shen.pojoClient.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserFeignImpl.class)
public interface UserFeign {

    @GetMapping("hello/hello1/{id}")
    User getq(@PathVariable("id") Long id);
}
