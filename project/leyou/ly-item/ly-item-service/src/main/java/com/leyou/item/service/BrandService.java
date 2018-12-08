package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.item.utils.PageResult;

public interface BrandService {
    /**
     * 商品分页数据
     * @param page
     * @param row
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    PageResult<Brand> queryBrandByPage(Integer page, Integer row, String sortBy, Boolean desc, String key);

}
