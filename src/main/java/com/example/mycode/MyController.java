package com.example.mycode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyController {

    @RequestMapping("/test")
    public String first() {

        return "Hello World";
    }
}
