package com.demo.test.test1;

import com.demo.test.test1.jasperReport.ReportExporter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/report1")
    public void reportTest1(HttpServletRequest request, HttpServletResponse response){
        List<Map> dataList = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("name","zhangsan");
        map1.put("old","20");
        Map map2 = new HashMap();
        map2.put("name","lisi");
        map2.put("old","21");
        dataList.add(map1);
        dataList.add(map2);

        String reportName = "test1";
        try {
            ReportExporter.exportReport(request,response,"report1","PDF",null,dataList,reportName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
