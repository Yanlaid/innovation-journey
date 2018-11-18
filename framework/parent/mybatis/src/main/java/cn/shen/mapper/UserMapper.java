package cn.shen.mapper;

import cn.shen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author shen
 */
public interface UserMapper {
    /**
     * 依据ID查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(@Param("id") long id);

    /**
     * 添加用户
     * ~
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 查询所有用户
     *
     * @return AarrayList<User>
     */
    List<User> queryAllUser();

    /**
     * 依据id删除用户
     *
     * @param id
     */
    void deleteUserById(long id);

    /**
     * 依据表名查找
     *
     * @param tableName
     * @return
     */
    List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 传递多个参数
     *
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 使用hashMap方式获取参数
     *
     * @param map
     * @return
     */
    User loginMap(Map<String, Object> map);

    /**
     * 通过模糊查询用户
     *
     * @param fuzzyName
     * @return
     */
    List<User> selectUserByFuzzyQueryName(@Param("fuzzyName") String fuzzyName);

    /**
     * 查询男性用户，如果输入了用户名，按用户名模糊查询
     *
     * @return
     */
    List<User> queryUserListLikeUserName(@Param("userName") String userName);

    /**
     * 查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     */

    List<User> queryUserListLikeUserNameOrAge(@Param("userName") String userName, @Param("age") Integer age);

    /**
     * 查询所有用户，如果输入了用户名按照用户名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
     */
    List<User> queryUserListLikeUserNameAndAge(@Param("age") Integer age, @Param("userName") String userName);
    /**
     * 修改用户信息，如果参数user中的某个属性为null，则不修改
     */
    void updateUserSelective(User user);

}
