package cn.shen.jpa3.dao;

import cn.shen.jpa3.pojo.SysRole;
import cn.shen.jpa3.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void test1() {
    }

    @Test
    /**
     *新增
     */
    @Transactional
    @Rollback(false)
    public void test2() {
        SysUser user1 = new SysUser();
        SysUser user2 = new SysUser();
        SysRole role1 = new SysRole();
        SysRole role2 = new SysRole();
        SysRole role3 = new SysRole();
        user1.setUserName("用户1");
        user2.setUserName("用户2");
        role1.setRoleName("角色一");
        role2.setRoleName("角色二");
        role3.setRoleName("角色三");
//        建立关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role2);
        user2.getRoles().add(role3);

//        反过来
        role1.getUsers().add(user1);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);
        role3.getUsers().add(user2);
//
        sysRoleDao.save(role1);
        sysRoleDao.save(role2);
        sysRoleDao.save(role3);
        sysUserDao.save(user1);
        sysUserDao.save(user2);

    }

    @Test
    public void deleteTest1() {
        /*拥有主键维护的表是可以直接删除的。不会被联合主键约束 */
        sysUserDao.deleteById(3L);
    }

    /*
     * 直接删除角色的话，是无法删除的*/
    @Test
    @Transactional
    @Rollback(false)
    public void DeleteTest2() {
/*
*        角色无法接触关系，但是用户可以先解除与之的关系，那么角色在
*        无主键约束下，就可以删除了
 */

        /*sysRoleDao.deleteById(1L);*/
        SysRole role = sysRoleDao.findById(1L).orElse(null);
        Set<SysUser> users = role.getUsers();
        for (SysUser user : users) {
            user.getRoles().remove(role);
        }
        sysRoleDao.delete(role);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3() {
        SysUser user = sysUserDao.findById(1L).orElse(null);
        assert user != null;
        Set<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            System.out.println(role);
        }
    }
}