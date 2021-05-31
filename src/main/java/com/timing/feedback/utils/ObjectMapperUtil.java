package com.timing.feedback.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @author cwh
 */
public class ObjectMapperUtil {

    /**
    * 定义常量对象
    * 优势1: 对象独一份节省空间
    * 优势2: 对象不允许别人随意篡改
    * @return:
    **/
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     *  将任意对象转化为JSON
     *  思考1: 任意对象对象应该使用Object对象来接
     *  思考2: 返回值是JSON串 所以应该是String
     *  思考3: 使用什么方式转化JSON   FASTJSON/objectMapper
     */
    public static String toJson(Object object){
        try {
            if(object == null){
                throw new RuntimeException("传递的参数object为null,请认真检查");
            }
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            //应该将检查异常,转化为运行时异常.
            throw new RuntimeException("传递的对象不支持json转化/检查是否有get/set方法");
        }
    }


    /**
    * 将任意的JSON串转化为对象  传递什么类型转化什么对象
    * @param json
    * @param target  Class<T>
    * @return: T
    **/
    public static <T> T toObject(String json,Class<T> target){

        if(!StringUtils.hasText(json) || target == null){
            throw new RuntimeException("传递的参数不能为null");
        }
        try {
          return MAPPER.readValue(json,target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("json转化异常");
        }
    }
}
