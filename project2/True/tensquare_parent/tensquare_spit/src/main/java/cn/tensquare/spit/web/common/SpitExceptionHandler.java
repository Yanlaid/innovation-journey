package cn.tensquare.spit.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpitExceptionHandler {
    @ExceptionHandler
    public ResultDTO errorHanler(Throwable e){
        return new ResultDTO(false, StatusCode.ERROR,e.getMessage());
    }
}
