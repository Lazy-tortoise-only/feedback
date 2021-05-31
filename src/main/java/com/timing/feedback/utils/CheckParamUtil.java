package com.timing.feedback.utils;

import com.timing.feedback.Exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * <p>
 *
 * </p>
 *
 * @author: cwh
 * @since 2021-05-28
 */
public class CheckParamUtil {
    /**
     *
     * @param bindingResult 检验结果
     * @param message 错误消息
     * @return:
     **/
    public static void check(BindingResult bindingResult, String message) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            String messages = bindingResult.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .reduce((m1, m2) -> m1 + "；" + m2)
                .orElse(message);
            throw new BizException(messages);
        }
    }
}
