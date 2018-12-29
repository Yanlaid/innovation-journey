package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {
    /**
     * 依据id查询列表
     */
    public List<Comment> findByArticleid(String articleid);
}
