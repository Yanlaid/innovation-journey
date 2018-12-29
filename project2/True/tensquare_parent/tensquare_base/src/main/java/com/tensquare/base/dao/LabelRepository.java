package com.tensquare.base.dao;

import com.tensquare.base.po.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Jeff Shen
 * 标签数据访问接口
 *  
 */
public interface LabelRepository extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}