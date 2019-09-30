package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
@Slf4j
@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        log.info("enter hello()");
        return "hello,world";
    }
}
