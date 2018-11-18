package cn.shen.jpa3.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_memo")
    private String roleMemo;

    /*两个表之间需要建立关系*/
    @ManyToMany(
            targetEntity = SysUser.class,
            mappedBy = "roles"
           /* cascade = CascadeType.REMOVE*/

    )
  /*  @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "rid",
                    referencedColumnName = "role_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "uid",
                    referencedColumnName = "user_id")
    )*/
    private Set<SysUser> users = new HashSet<SysUser>();

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }


    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleMemo='" + roleMemo + '\'' +
                '}';
    }
}
