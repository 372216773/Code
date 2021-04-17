package com.wj.spring.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public Map<String, Object> list() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","wj");
        map.put("password",123);
        map.put("message","UserService的list");
        return map;
    }
}
