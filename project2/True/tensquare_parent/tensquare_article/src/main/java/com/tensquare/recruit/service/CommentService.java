package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.CommentRepository;
import com.tensquare.recruit.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

/**
 * @author Jeff Shen
 * 文章评论业务层
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存评论
     *
     * @param comment
     */
    public void addComment(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentRepository.save(comment);
    }

    /**
     * 依据ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid) {
        return commentRepository.findByArticleid(articleid);
    }

    /**
     * 删除评论
     * @param articleid
     */
    public void deleteArticleById(String articleid) {
        commentRepository.deleteById(articleid);
    }
}
