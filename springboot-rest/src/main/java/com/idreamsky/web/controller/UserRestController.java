package com.idreamsky.web.controller;

import com.idreamsky.web.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: colby
 * @Date: 2019/1/26 15:25
 */
@RestController
public class UserRestController {
    @PostMapping(value = "/echo/user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User user(User user) {
        return user;
    }
}
