package com.tensquare.base.service;

import com.tensquare.base.po.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Jeff Shen
 */
public interface LabelService {
    /**
     * 新增标签
     * @param label
     */
    public void saveLabel(Label label);

    /**
     * 查询所有标签
     * @return
     */
    List<Label> findAllLabel();

    /**
     * 通过id修改标签
     * @param lavelId
     * @param label
     */
    void updateLabelById(String lavelId, Label label);

    /**
     * 通过ID删除
     * @param labelId
     */
    void deleteLabelById(String labelId);

    /**
     * 通过ID查找
     * @param labelId
     */
    Label findById(String labelId);

    /**
     * 通过条件查找
     * @param searchMap
     */
    List<Label> findByCondition(Map<String, Object> searchMap);

    /**
     * 依据条件查询且分页
     * @param page
     * @param rows
     */
    Page<Label> findByConditionAndPage(Map<String,Object> searchMap, Integer page, Integer rows);
}
