package com.idreamsky.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

/**
 * @Author: colby
 * @Date: 2019/1/26 18:08
 */
@Controller
public class PropertiesController {
    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=utf-8"
    )
    @ResponseBody
    public Properties addProperties(Properties props) {
        System.out.println(props);
        return props;
    }
}
