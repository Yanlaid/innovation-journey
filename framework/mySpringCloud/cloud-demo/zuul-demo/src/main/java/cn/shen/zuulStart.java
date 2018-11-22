package cn.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
/*
    TODO
        开启
        zuul网关
* */
@EnableZuulProxy
@EnableDiscoveryClient
public class zuulStart {
    public static void main(String[] args) {
        SpringApplication.run(zuulStart.class, args);
    }
}
