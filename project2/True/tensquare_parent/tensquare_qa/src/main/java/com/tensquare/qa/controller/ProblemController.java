package com.tensquare.qa.controller;

import com.tensquare.qa.client.LabelClient;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LabelClient labelClient;

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO findAll() {
        return new ResultDTO(true, StatusCode.OK, "查询成功", problemService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDTO findById(@PathVariable String id) {

        return new ResultDTO(true, StatusCode.OK, "查询成功", labelClient.findById(id));
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
        Page<Problem> pageList = problemService.findPage(page, size);
        return new ResultDTO(true, StatusCode.OK, "查询成功", new PageResultDTO<Problem>(pageList.getTotalElements(), pageList.getContent()));
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
        Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
        return new ResultDTO(true, StatusCode.OK, "查询成功", new PageResultDTO<Problem>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     *
     * @param problem
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO add(@RequestBody Problem problem) {
        Claims user_claims = (Claims) request.getAttribute("user_claims");
        if (user_claims != null) {
            problemService.add(problem);
            return new ResultDTO(true, StatusCode.OK, "增加成功");
        }
        return new ResultDTO(false, StatusCode.ACCESSERROR, "权限不足");
    }

    /**
     * 修改
     *
     * @param problem
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultDTO update(@RequestBody Problem problem, @PathVariable String id) {
        problem.setId(id);
        problemService.update(problem);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDTO delete(@PathVariable String id) {
        problemService.deleteById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    @GetMapping("/newlist/{label}/{page}/{size}")
    public ResultDTO findNewlistPageWithLabel(@PathVariable String label, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Problem> newList = problemService.findNewlistPageWithLabel(label, page, size);
        return new ResultDTO(
                true, 20000, "查询成功",
                new PageResultDTO<Problem>(newList.getTotalElements(),
                        newList.getContent())
        );
    }

    @GetMapping("/hotlist/{label}/{page}/{size}")
    public ResultDTO findHotlistPageWithLabel(@PathVariable String label,
                                              @PathVariable Integer page,
                                              @PathVariable Integer size) {
        Page<Problem> problems = problemService.findHotlistPageWithLabel(label, page, size);
        return new ResultDTO(true, 20000, "查询成功",
                new PageResultDTO<Problem>(
                        problems.getTotalElements(),
                        problems.getContent()
                ));
    }

    /**
     * 等待回答的问题安装时间排序
     */
    @GetMapping("/waitlist/{label}/{page}/{size}")
    public ResultDTO waitingForAnswerListPageWithLabel(@PathVariable String label,
                                                       @PathVariable Integer page,
                                                       @PathVariable Integer size) {
        Page<Problem> problems = problemService.waitingForAnswerListPageWithLabel(label, page, size);
        return new ResultDTO(true, 20000, "查询成功",
                new PageResultDTO<Problem>(
                        problems.getTotalElements(),
                        problems.getContent()));
    }
}
