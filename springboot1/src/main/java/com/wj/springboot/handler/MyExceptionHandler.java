package com.wj.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@ResponseBody
//返回的结果都以json的格式返回
@ControllerAdvice
//使用该注解表示开启了全局异常的捕获
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    //定义捕获异常的类型为Exception
    public Map<String,Object> handlerException(Exception e) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code",888);
        map.put("mes",e.getMessage());
        return map;
    }
}
