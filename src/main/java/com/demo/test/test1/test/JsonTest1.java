package com.demo.test.test1.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonTest1 {
    public static void main(String[] args){
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("a","aaa");
        System.out.println(jsonObject1);

        String string1 = JSON.toJSONString(jsonObject1);
        System.out.println(string1);

        String string2 = "{\"b\":\"bbb\"}";
        JSONObject jsonObject2 = JSON.parseObject(string2);
        System.out.println(jsonObject2);
    }
}
