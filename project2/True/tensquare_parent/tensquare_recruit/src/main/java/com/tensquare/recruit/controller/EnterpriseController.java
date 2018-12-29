package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
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
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultDTO findAll() {
        return new ResultDTO(true, 1000, "查询成功", enterpriseService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultDTO findById(@PathVariable String id) {
        return new ResultDTO(true, 1000, "查询成功", enterpriseService.findById(id));
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
        Page<Enterprise> pageList = enterpriseService.findPage(page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<>(pageList.getTotalElements(), pageList.getContent()));
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
        Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);
        return new ResultDTO(true, 1000, "查询成功", new PageResultDTO<>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 增加
     *
     * @param enterprise
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultDTO add(@RequestBody Enterprise enterprise) {
        enterpriseService.add(enterprise);
        return new ResultDTO(true, 1000, "增加成功");
    }

    /**
     * 修改
     *
     * @param enterprise
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultDTO update(@RequestBody Enterprise enterprise, @PathVariable String id) {
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new ResultDTO(true, 1000, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultDTO delete(@PathVariable String id) {
        enterpriseService.deleteById(id);
        return new ResultDTO(true, 1000, "删除成功");
    }

    /**
     * 查找热门企业
     */
    @GetMapping("/search/hotlist")
    public ResultDTO findhotEnt() {
        return new ResultDTO(true, 20000, "查询成功", enterpriseService.findhotEnt("1"));
    }
}
