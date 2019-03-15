package com.invicto.common.usermanagmentservice.controller;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceBean")
    private UserSevrice service;

    @Autowired
    private Gson gson;

    @GetMapping("/{id}")
    public String getUser(){


        return "Hello";
    }

    @PostMapping()
    public ResponseEntity<String> addNewUser(UserCreationRequest request) throws Exception{
        ApiResponse response = service.createNewUser(request);
        return response.buildResponse(gson);
    }

    @DeleteMapping("/{id}")
    public void removeUser(){

    }

    @PutMapping
    public void updateUser(){

    }
    @PostMapping("/{id}")
    public void grantUserRoles(ApiRequest request){

    }
}
