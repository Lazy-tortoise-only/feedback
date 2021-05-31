package com.timing.feedback.controller;

import com.timing.feedback.Exception.BizException;
import com.timing.feedback.vo.ResultCodeEnum;
import com.timing.feedback.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author: cwh
 * @since 2021-05-28
 */
@ControllerAdvice
@Slf4j
public class OverAllExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param req 请求
     * @param e 错误
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultVO bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultVO.error().code(e.getErrorCode()).message(e.getErrorMsg());
    }


    /**
     * 处理其他异常
     * @param req 请求
     * @param e 错误
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultVO exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return ResultVO.error(ResultCodeEnum.COMMON_FAIL);
    }
}
