package com.tensquare.recruit.web.controller;

import com.tensquare.recruit.pojo.Comment;
import com.tensquare.recruit.service.CommentService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping
    public ResultDTO save(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new ResultDTO(true, StatusCode.OK,"评论成功");
    }

    /**
     * 依据ID查询评论
     * @param articleid
     * @return
     */
    @GetMapping("/article/{articleid}")
    public ResultDTO findByArticleid(@PathVariable String articleid){
        return new ResultDTO(true,StatusCode.OK,"查询成功",commentService.findByArticleid(articleid));
    }
    /**
     * 删除评论
     */
    @DeleteMapping("/article/{articleid}")
    public ResultDTO deleteArticle(@PathVariable String articleid){
        commentService.deleteArticleById(articleid);
        return new ResultDTO(true,StatusCode.OK,"删除成功");
    }
}
