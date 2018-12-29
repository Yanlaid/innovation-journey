package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 审核文章
     * @param articleId
     * @param status
     */
    @Query("update Article set state = ?2 where id = ?1")
    @Modifying
    void reviewArticle(String articleId, String status);

    /**
     * 操作点赞数
     * @param articleId
     * @param num
     */
    @Modifying
    @Query("update Article set thumbup = thumbup + ?2 where id = ?1")
    void operateTheNumberOfLike(String articleId, Integer num);
}
