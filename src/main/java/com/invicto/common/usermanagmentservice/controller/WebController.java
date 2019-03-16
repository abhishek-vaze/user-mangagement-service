package com.invicto.common.usermanagmentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class WebController {

    @GetMapping
    public String signIn(){
        return "sign-in";
    }
}
