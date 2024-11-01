package com.seoil.pk.poch.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class GameController {


    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
