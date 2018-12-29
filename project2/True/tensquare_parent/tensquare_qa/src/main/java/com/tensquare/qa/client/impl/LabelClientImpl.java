package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.LabelClient;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.stereotype.Component;

/**
 * Hytrix 熔断器配置。搭配Feign使用
 */
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public ResultDTO findById(String labelId) {
        return new ResultDTO(false, StatusCode.ERROR, "熔断器启动。");
    }
}
