package com.timing.feedback.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * 公共返回结果
 * @author NieChangan
 */
@Data
public class ResultVO {

    private Boolean success;

    private String code;

    private String message;

    private Map<String,Object> data;

    /**
     * 构造方法私有化,里面的方法都是静态方法
     * 达到保护属性的作用
     */
    private ResultVO(){
        data = new HashMap<>();
    }

    public static ResultVO ok(){
        ResultVO result = new ResultVO();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static ResultVO error(){
        ResultVO result = new ResultVO();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.COMMON_FAIL.getCode());
        result.setMessage(ResultCodeEnum.COMMON_FAIL.getMessage());
        return result;
    }

    public static ResultVO error(ResultCodeEnum resultCodeEnum) {
        ResultVO result = new ResultVO();
        result.setSuccess(false);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 自定义返回成功与否
     * @param success
     * @return
     */
    public ResultVO success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultVO message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultVO code(String code){
        this.setCode(code);
        return this;
    }

    public ResultVO data(String key, Object value){
        this.data.put(key,value);
        return this;
    }

    public ResultVO data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
