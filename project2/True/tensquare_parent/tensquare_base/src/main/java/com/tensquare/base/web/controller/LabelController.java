package com.tensquare.base.web.controller;

import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Jeff Shen
 * 标签业务控制层
 */
@CrossOrigin
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 添加标签
     */
    @PostMapping
    public ResultDTO addLabel(@RequestBody Label label) {
        labelService.saveLabel(label);
        return new ResultDTO(true, StatusCode.OK, "添加成功");
    }

    /**
     * 查询所有标签
     */
    @GetMapping
    public ResultDTO findAllLabel() {
        return new ResultDTO(true, 20000, "查询成功", labelService.findAllLabel());
    }

    /**
     * 修改标签
     */
    @PutMapping("/{labelId}")
    public ResultDTO updateLabelById(@PathVariable String labelId, @RequestBody Label label) {
        labelService.updateLabelById(labelId, label);
        return new ResultDTO(true, 20000, "修改成功");
    }

    /**
     * 移除标签
     */
    @DeleteMapping("/{id}")
    public ResultDTO remove(@PathVariable String id) {
        labelService.deleteLabelById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 依据ID查询标签
     */
    @GetMapping("/{labelId}")
    public ResultDTO findById(@PathVariable String labelId) {
        return new ResultDTO(true, 20000, "查询成功", labelService.findById(labelId));
    }

    /**
     * 依据条件查询
     */
    @PostMapping("/search")
    public ResultDTO findByCondition(@RequestBody Map<String, Object> searchMap) {
        return new ResultDTO(true, 20000, "查询成功", labelService.findByCondition(searchMap));
    }

    /**
     * 条件分页查询
     */
    @PostMapping("/search/{page}/{size}")
    public ResultDTO findByConditionAndPage(@RequestBody Map<String, Object> searchMap, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Label> pageLabel = labelService.findByConditionAndPage(searchMap, page, size);
        return new ResultDTO(true,20000,"查询且分页成功",new PageResultDTO<Label>(pageLabel.getTotalElements(),pageLabel.getContent()));
    }
}
