package cn.shen.jpa3.dao;

import cn.shen.jpa3.pojo.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysRoleDao extends JpaRepository<SysRole, Long> ,JpaSpecificationExecutor<SysRole> {
}
