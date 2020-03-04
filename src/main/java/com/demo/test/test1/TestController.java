package com.demo.test.test1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }
}
