package com.idreamsky.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: colby
 * @Date: 2019/1/20 12:17
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld() {
        return "hello-world";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
