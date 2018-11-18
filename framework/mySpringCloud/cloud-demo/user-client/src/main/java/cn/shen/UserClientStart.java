package cn.shen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
public class  UserClientStart {
    public static void main(String[] args) {
        SpringApplication.run(UserClientStart.class);
    }

    @Bean
    /*
    * TODO
    *   @LoadBalanced注解是用于开启client的负载均衡功能，在多提供者实例的情况下。使用适合算法来
    *   选取实例。
    *   放在RestTemplate上*/
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
