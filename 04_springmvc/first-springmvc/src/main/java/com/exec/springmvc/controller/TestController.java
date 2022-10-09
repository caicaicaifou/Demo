package com.exec.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/test01") //localhost/test
    @ResponseBody //直接向响应输出字符串数据,不跳转页面
    public String test() {
        return "Hello Spring MVC1";
    }
}
