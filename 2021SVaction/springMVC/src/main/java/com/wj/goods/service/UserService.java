package com.wj.goods.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public void list() {
        System.out.println("userService的list()");
    }

    public Map<String, Object> getData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","admin");
        hashMap.put("age",12);
        return hashMap;
    }
}
