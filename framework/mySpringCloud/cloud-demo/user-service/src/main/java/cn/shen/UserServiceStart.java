package cn.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.shen.mapper")
@EnableDiscoveryClient
public class UserServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceStart.class);
    }
}
