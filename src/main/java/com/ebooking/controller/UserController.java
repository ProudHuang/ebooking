package com.ebooking.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first")
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String first() {
        log.info("我是第一次请求接口");
        return "Hello World";
    }
}
