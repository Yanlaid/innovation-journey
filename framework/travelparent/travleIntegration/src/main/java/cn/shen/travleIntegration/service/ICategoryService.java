package cn.shen.travleIntegration.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ICategoryService {
    String getCategoryList() throws JsonProcessingException;
}
