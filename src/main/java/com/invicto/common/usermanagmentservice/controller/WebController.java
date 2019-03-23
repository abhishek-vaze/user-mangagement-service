package com.invicto.common.usermanagmentservice.controller;

import com.invicto.common.usermanagmentservice.response.application.ApplicationListResponse;
import com.invicto.common.usermanagmentservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/web")
public class WebController {

    @Autowired
    ApplicationService service;

    @GetMapping("/view/applications")
    public String getAllApplication(Model model){

        ApplicationListResponse respone = (ApplicationListResponse)service.getAllApplications();
        System.out.println("List size is "+respone.getApplicationList().size());
        model.addAttribute("applications",respone.getApplicationList());

        return "view-all-applications";
    }

    @GetMapping("/view/users/{applicationId}")
    public String getAllUsers(@PathVariable() int applicationId){
        System.out.println("application id is "+applicationId);

        return "view-all-users";
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
