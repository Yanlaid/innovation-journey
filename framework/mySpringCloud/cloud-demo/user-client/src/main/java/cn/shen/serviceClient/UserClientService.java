package cn.shen.serviceClient;

import cn.shen.pojoClient.User;

import java.util.List;

public interface    UserClientService {
    List<User> queryUsersByIds(List<Long> ids);
    List<User> queryUsersByIdsDefaultFallback(List<Long> ids);
}
