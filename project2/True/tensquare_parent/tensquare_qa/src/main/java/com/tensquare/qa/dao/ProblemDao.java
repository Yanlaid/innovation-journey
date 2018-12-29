package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 依据标签ID查询最新问题且分页倒序排序
     *
     * @param label
     * @param pageInfo
     * @return
     */
    @Query("select p from Problem p where p.id " +
            "in(select problemid from PI where labelid=?1) " +
            "order by p.replyname desc")
    Page<Problem> findNewlistPageWithLabel(String label, Pageable pageInfo);

    /**
     * 查询热门回答
     *
     * @param label
     * @param pageInfo
     * @return
     */
    @Query("select p from Problem p where p.id " +
            "in(select problemid from PI where labelid = ?1) " +
            "order by p.reply desc ")
    Page<Problem> findHotlistPageWithLabel(String label, Pageable pageInfo);

    /**
     * 依据标签的未回答问题列表分页
     */
    @Query("select p from Problem p where p.id " +
            "in(select problemid from PI where labelid = ?1) " +
            "and p.reply = 0 " +
            "order by p.createtime desc ")
    Page<Problem> waitingForAnswerListPageWithLabel(String label, Pageable pageInfo);
}
