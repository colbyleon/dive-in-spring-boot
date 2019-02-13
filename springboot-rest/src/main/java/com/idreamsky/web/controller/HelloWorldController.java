package com.idreamsky.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: colby
 * @Date: 2019/1/27 16:35
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index() {
        return "index";
    }


}
