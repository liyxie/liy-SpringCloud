package com.liy.auth.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiY
 */

@RestController
public class TokenController {

    @GetMapping("/test")
    public String test(){
        return "2";
    }

    @GetMapping("/test2")
    public String test1(){
        return "2";
    }


}

