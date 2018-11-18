package cn.shen.travleIntegration.service.impl;

import cn.shen.travleIntegration.mapper.CategoryMapper;
import cn.shen.travleIntegration.pojo.Category;
import cn.shen.travleIntegration.service.ICategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public String getCategoryList() throws JsonProcessingException {
        String categoryList;
        // Jedis jedis = JedisUtil.getJedis();

        categoryList = redisTemplate.opsForValue().get("categoryList");
        if (StringUtils.isBlank(categoryList)) {
            List<Category> categories = categoryMapper.getCategoryList();
            categoryList = new ObjectMapper().writeValueAsString(categories);
            redisTemplate.opsForValue().set("categoryList", categoryList);
        }
        // jedis.close();
        return categoryList;

    }
}
