package com.demo.test.test1.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.test.test1.tools.HttpPostTool;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HttpTest2 {
    public static void main(String[] args){

        Map<String, Object> reqHead = new HashMap<>();
        reqHead.put("methodCode","B010001");

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("appId","klbfd21c320769440185a68a561b2af7b4");
        reqBody.put("appSecret","ae24b60b6bca413badadbc2a397e2ab8");

        Map<String, Object> req = httpReqPackage(reqHead,reqBody);

        System.out.println(req);

        String param = JSON.toJSONString(req);
        System.out.println(param);

        String uri = "https://test2.mcsca.com.cn/sicpap-inter/service/datasecurity/token";
        String entity = "param="+param;

        String res = HttpPostTool.sendHttpPost(uri,entity);
        System.out.println(res);

        JSONObject resJson = JSON.parseObject(res);
        JSONObject resHead = resJson.getJSONObject("resHead");
        if("2000".equals(resHead.getString("resultCode"))){
            String token = resJson.getJSONObject("resBody").getString("value");
            System.out.println(token);
        }
    }


    public static Map<String, Object> httpReqPackage(Map reqHead, Map reqBody){
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        LocalDateTime localDateTime = LocalDateTime.now(zoneOffset);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

        reqHead.put("reqTime",localDateTime.format(dateTimeFormatter));
        reqHead.put("appId","klbfd21c320769440185a68a561b2af7b4");
        reqHead.put("businessNO","CSII"+localDateTime.toInstant(zoneOffset).toEpochMilli()) ;
        reqHead.put("serialNo","CSII"+localDateTime.toInstant(zoneOffset).toEpochMilli());

        Map<String, Object> req = new HashMap<>();
        req.put("reqHead",reqHead);
        req.put("reqBody",reqBody);
        return req;
    }
}
