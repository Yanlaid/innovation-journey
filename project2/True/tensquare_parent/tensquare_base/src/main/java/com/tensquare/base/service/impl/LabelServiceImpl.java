package com.tensquare.base.service.impl;

import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jeff Shen
 * 标签业务逻辑类
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存标签
     */
    public void saveLabel(Label label) {
        label.setId(idWorker.nextId() + "");
        labelRepository.save(label);
    }

    /**
     * 查询所有标签
     *
     * @return
     */
    @Override
    public List<Label> findAllLabel() {
        return labelRepository.findAll();
    }

    /**
     * 通过id修改标签
     *
     * @param lavelId
     * @param label
     */
    @Override
    public void updateLabelById(String lavelId, Label label) {
        label.setId(lavelId);
        labelRepository.save(label);
    }

    @Override
    public void deleteLabelById(String labelId) {
        labelRepository.deleteById(labelId);
    }

    /**
     * 通过ID查找
     *
     * @param labelId
     */
    @Override
    public Label findById(String labelId) {
        return labelRepository.findById(labelId).get();
    }

    /**
     * 通过条件查找
     *
     * @param searchMap
     */
    @Override
    public List<Label> findByCondition(Map<String, Object> searchMap) {

        return labelRepository.findAll(SearchMapSpec(searchMap));
    }

    /**
     * 依据条件查询且分页
     *
     * @param page
     * @param rows
     */
    @Override
    public Page<Label> findByConditionAndPage(Map<String, Object> searchMap, Integer page, Integer rows) {

        return labelRepository.findAll(SearchMapSpec(searchMap), PageRequest.of(page - 1, rows));
    }

    /**
     * 对条件查询的方法抽取封装
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> SearchMapSpec(Map<String, Object> searchMap) {
        return (Specification<Label>) (root, criteriaQuery, cb) -> {
            ArrayList<Predicate> ps = new ArrayList<>();
            if (!StringUtils.isEmpty(searchMap.get("labelname"))) {

                ps.add(cb.like(root.get("labelname").as(String.class), "%" + searchMap.get("labelname") + "%"));
            }
            if (!StringUtils.isEmpty(searchMap.get("state"))) {
                ps.add(cb.equal(root.get("state").as(String.class), searchMap.get("state")));
            }
            if ((!StringUtils.isEmpty(searchMap.get("recommend")))) {
                ps.add(cb.equal(root.get("recommend").as(String.class), searchMap.get("recommend")));
            }
            return cb.and(ps.toArray(new Predicate[ps.size()]));
        };
    }
}
