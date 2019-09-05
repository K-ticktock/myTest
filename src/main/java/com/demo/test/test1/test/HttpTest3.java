package com.demo.test.test1.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.test.test1.tools.HttpPostTool;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HttpTest3 {
    public static void main(String[] args){

        Map<String, Object> reqHead = new HashMap<>();
        reqHead.put("methodCode","B070001");
        reqHead.put("token","4d93c59980604b3a8452bb6ade980ab6");

        Map<String, Object> temp_param = new HashMap<>();
        temp_param.put("DS_UID","102030400003");
        temp_param.put("C_BORROWING_AMOUNT","40000");
        temp_param.put("DS_CONTRACT_NO","JK102030002");
        temp_param.put("C_ID_NUMBER","130524199001012654");
        temp_param.put("C_BORROWING_TIME","6");
        temp_param.put("C_TRUE_NAME","test001");

        Map<String, Object> data = new HashMap<>();
        data.put("TEMPL_ID","klc8b99c6992e945358d1120240fe23cbf");
        data.put("TEMP_PARAM",temp_param);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("data", data);

        Map<String, Object> req = httpReqPackage(reqHead,reqBody);

        System.out.println(req);

        String param = JSON.toJSONString(req);
        System.out.println(param);

        String uri = "https://test2.mcsca.com.cn/sicpap-inter/service/datasecurity/dsSave";
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
