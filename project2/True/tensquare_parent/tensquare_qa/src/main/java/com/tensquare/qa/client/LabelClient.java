package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.LabelClientImpl;
import dto.ResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign远程调用其他微服务组件
 */
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)

public interface LabelClient {
    @GetMapping("/label/{labelId}")
    public ResultDTO findById(@PathVariable String labelId);
}
