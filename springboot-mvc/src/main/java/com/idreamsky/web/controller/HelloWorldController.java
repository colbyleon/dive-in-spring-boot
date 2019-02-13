package com.idreamsky.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/s")
    @ResponseBody
    public String required(@RequestParam int value) {
        return value * value + "";
    }
}