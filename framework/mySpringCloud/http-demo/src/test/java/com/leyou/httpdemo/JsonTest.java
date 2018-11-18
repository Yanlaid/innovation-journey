package com.leyou.httpdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.httpdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpDemoApplication.class)
public class JsonTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testJson() throws IOException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");
        // 序列化
        String json = mapper.writeValueAsString(user);
        // 反序列化
        User users = mapper.readValue(json, User.class);
    }

    @Test
    public void testJson1() throws IOException {
        User user = new User();
        user.setId(8L);
        user.setAge(21);
        user.setName("柳岩");
        user.setUserName("liuyan");


        // 序列化,得到对象集合的json字符串
        String json = mapper.writeValueAsString(Arrays.asList(user, user));
        System.out.println("json = " + json);
        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        List<User> users = mapper.readValue(json, new TypeReference<List<User>>() {});

//        List<User> users = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for (User u : users) {
            System.out.println("u = " + u);
        }
    }
}
