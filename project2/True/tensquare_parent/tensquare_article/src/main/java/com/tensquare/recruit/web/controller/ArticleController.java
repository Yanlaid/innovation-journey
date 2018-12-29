package com.tensquare.recruit.web.controller;

import com.tensquare.recruit.pojo.Article;
import com.tensquare.recruit.service.ArticleService;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO findAll() {
        return new ResultDTO(true, 1000, "查询成功", articleService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDTO findById(@PathVariable String id) {
        return new ResultDTO(true, 1000, "查询成功", articleService.findArticleById(id));
    }


    /**
     * 分页查询全部数据
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public ResultDTO findPage(@PathVariable int page, @PathVariable int size) {
        Page<Article> pageList = articleService.findPage(page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<Article>(pageList.getTotalElements(), pageList.getContent()));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.POST)
    public ResultDTO findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageList = articleService.findSearch(searchMap, page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     *
     * @param article
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO add(@RequestBody Article article) {
        articleService.add(article);
        return new ResultDTO(true, 1000, "增加成功");
    }

    /**
     * 修改
     *
     * @param article
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultDTO update(@RequestBody Article article, @PathVariable String id) {
        article.setId(id);
        articleService.update(article);
        return new ResultDTO(true, 1000, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDTO delete(@PathVariable String id) {
        articleService.deleteById(id);
        return new ResultDTO(true, 1000, "删除成功");
    }

    /**
     * 审核文章
     */
    @PutMapping("/examine/{articleId}")
    public ResultDTO reviewArticle(@PathVariable String articleId) {
        articleService.reviewArticle(articleId);
        return new ResultDTO(true, 20000, "审核成功");
    }
    /**
     * 增    加点赞数
     */
    @PutMapping("/thumbup/{articleId}")
    public ResultDTO increaseTheNumberOfLike(@PathVariable String articleId){
        articleService.increaseTheNumberOfLike(articleId);
        return new ResultDTO(true,20000,"点赞成功");
    }
}
