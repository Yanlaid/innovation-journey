package cn.shen.travleIntegration.service;

import cn.shen.travleIntegration.pojo.User;

public interface IUserService {
    /**
     * <p>Title:      注册用户. </p>
     * <p>Description TODO</p>
     *
     * @param         user
     * @Author        沈欣然
     * @CreateDate    2018/10/13 7:33
     * @return        void
     */
    void register(User user) throws Exception;

    /**
     * 校验用户激活码
     * @param code
     * @return 是否激活成功
     */
    Boolean active(String code);

    User login(User user) throws Exception;
}
