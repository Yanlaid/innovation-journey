package cn.shen.dao.impl;

import cn.shen.dao.IUserDao;
import cn.shen.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements IUserDao {


    /**
     * 成员属性，使用构造方法进行赋值
     */
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 依据ID查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(long id) {

        return sqlSession.selectOne("UserDaoMapper.queryUserById",id);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        sqlSession.insert("UserDaoMapper.insertUser",user);
        sqlSession.commit();
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        sqlSession.update("UserDaoMapper.updateUser",user);
        sqlSession.commit();
    }

    /**
     * 查询所有用户
     *
     * @return AarrayList<User>
     */
    @Override
    public List<User> queryAllUser() {
        return sqlSession.selectList("UserDaoMapper.queryAllUser");
    }

    /**
     * 依据id删除用户
     *
     * @param id
     */
    @Override
    public void deleteUserById(long id) {
        sqlSession.delete("UserDaoMapper.deleteUserById",id);
        sqlSession.commit();
    }
}
