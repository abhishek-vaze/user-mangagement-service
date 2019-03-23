package com.invicto.common.usermanagmentservice.controller;

import com.invicto.common.usermanagmentservice.response.application.ApplicationListResponse;
import com.invicto.common.usermanagmentservice.response.user.UserListResponse;
import com.invicto.common.usermanagmentservice.response.web.UserRoleDtoListResponse;
import com.invicto.common.usermanagmentservice.service.ApplicationService;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/web")
public class WebController {

    @Autowired
    ApplicationService service;

    @Autowired
    UserSevrice userSevrice;

    @GetMapping("/view/applications")
    public String getAllApplication(Model model){

        ApplicationListResponse respone = (ApplicationListResponse)service.getAllApplications();
        model.addAttribute("applications",respone.getApplicationList());

        return "view-all-applications";
    }

    @GetMapping("/view/users/{applicationId}")
    public String getAllUsers(@PathVariable() int applicationId,Model model){

        UserRoleDtoListResponse userList = (UserRoleDtoListResponse)userSevrice.getAllUsersByApplicationId(applicationId);
        model.addAttribute("users",userList.getDto());
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
