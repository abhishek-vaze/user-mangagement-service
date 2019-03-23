package com.invicto.common.usermanagmentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/web")
public class WebController {

    @GetMapping("/view/applications")
    public String getAllApplication(){
        return "view-all-applications";
    }

    @GetMapping("/view/users")
    public String getAllUsers(){
        return "all-users";
    }
    @GetMapping("/add/application")
    public String addNewApplication(){
        return "new-application";
    }
    @GetMapping("/add/user")
    public String addNewUser(){
        return "newUser";
    }
}
