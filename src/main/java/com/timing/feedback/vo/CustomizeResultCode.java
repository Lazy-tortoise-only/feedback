package com.timing.feedback.vo;

/**
 * @author NieChangan
 */
public interface CustomizeResultCode {

    /**
     * 获取错误状态码
     * @return 错误状态码
     */
    String getCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getMessage();
}
