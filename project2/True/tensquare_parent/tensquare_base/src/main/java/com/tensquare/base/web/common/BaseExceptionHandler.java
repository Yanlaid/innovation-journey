package com.tensquare.base.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jeff Shen
 * 异常处理类
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler
    public ResultDTO errorHandler(Throwable e){
        return new ResultDTO(false, StatusCode.ERROR, e.getMessage());
    }
}
