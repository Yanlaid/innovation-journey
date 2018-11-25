package com.leyou.item.service;

import com.leyou.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategorys(Long pid);
}
