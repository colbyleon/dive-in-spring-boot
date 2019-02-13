package com.idreamsky.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: colby
 * @Date: 2019/1/13 12:27
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("message")
    public String message(){
        return "hello world good yes 666";
    }

    @ModelAttribute("userAgent")
    public String userAgent(@RequestHeader("User-Agent")String userAgent){
        return userAgent;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable t) {
        return ResponseEntity.ok(t.getMessage());
    }
}
