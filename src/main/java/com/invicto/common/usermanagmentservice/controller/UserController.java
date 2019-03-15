package com.invicto.common.usermanagmentservice.controller;

import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("emailValidatorBean")
    Validator emailValidator;

    @Autowired
    @Qualifier("adressValidatorBean")
    Validator adressValidator;

    @Autowired
    @Qualifier("mobileNumberValidatorBean")
    Validator mobileNumberValidator;

    @Autowired
    @Qualifier("userServiceBean")
    UserSevrice service;

    @GetMapping("/detail/{id}")
    public String getUser(){
        return "Hello";
    }

    @PostMapping()
    public void addNewUser(UserCreationRequest request) throws Exception{

             request.validate(emailValidator);
             request.validate(adressValidator);
             request.validate(mobileNumberValidator);
             service.createNewUser(request);
    }

    @DeleteMapping("")
    public void removeUser(){

    }

    @PutMapping
    public void updateUser(){

    }
    @PostMapping("/role")
    public void grantUserRoles(){

    }
}
