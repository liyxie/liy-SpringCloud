package com.liy.module.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.liy.module.user.service.Test;

/**
 * @Author LiY
 */

@RestController
public class TestController {

    @Autowired
    private Test test;

    @GetMapping("/test1")
    public String test(){
        test.test1();

        return "1";
    }
}
