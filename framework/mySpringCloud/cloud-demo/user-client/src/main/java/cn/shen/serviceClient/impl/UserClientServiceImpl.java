package cn.shen.serviceClient.impl;

import cn.shen.pojoClient.User;
import cn.shen.serviceClient.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClientServiceImpl implements UserClientService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;


    @Override
    public List<User> queryUsersByIds(List<Long> ids) {

        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        int size = instances.size();
        String host = instances.get(size - 1).getHost();
        int port = instances.get(size - 1).getPort();*/
        String baseUrl = "http://user-service/hello/hello1/";
        ArrayList<User> users = new ArrayList<>();
        ids.forEach(id -> {
            users.add(restTemplate.getForObject(baseUrl+ id, User.class));
        });
        return users;
    }

    /** TODO
     *      hyxtris熔断器的回调方法
     * @param ids
     * @return
     */
    @Override
    public List<User> queryUsersByIdsDefaultFallback(List<Long> ids) {
//        #
        String baseUrl = "http://user-service/hello/hello1/";
        ArrayList<User> users = new ArrayList<>();
        ids.forEach(id -> {
            users.add(restTemplate.getForObject(baseUrl+ id, User.class));
        });
        return users;
    }
}
