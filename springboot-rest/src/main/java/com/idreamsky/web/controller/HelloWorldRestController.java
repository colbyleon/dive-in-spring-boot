package com.idreamsky.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: colby
 * @Date: 2019/1/21 22:23
 */
@RestController
public class HelloWorldRestController {
//    @CrossOrigin("*")
    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value = "message",required = false) String message, HttpServletResponse response) {
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
        return "Hello, World " + message;
    }
}
