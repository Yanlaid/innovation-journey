package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     * 查询状态为2（代表是推荐的职位）并以创建日期降序排序，查询前4条记录
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String status);

    /**
     * 查询推荐的职位 12条
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String status);

}
