package com.invicto.common.usermanagmentservice.controller;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import com.invicto.common.usermanagmentservice.util.Validator;
import io.swagger.annotations.Api;
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
    public ResponseEntity<String> getUser(@PathVariable String id){
        ApiResponse response = service.findUserById(Integer.parseInt(id));
        return response.buildResponse(gson);
    }

    @PostMapping()
    public ResponseEntity<String> addNewUser(@RequestBody  UserCreationRequest request) throws Exception{
        ApiResponse response = service.createNewUser(request);
        return response.buildResponse(gson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable String id){
        ApiResponse response = service.removeUser(Integer.parseInt(id));
        return response.buildResponse(gson);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@PathVariable String id,@RequestBody  UserCreationRequest request){
        return null;
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> grantUserRoles(@PathVariable String id,@RequestBody ApiRequest request){
        return null;
    }
    @GetMapping()
    public ResponseEntity<String> getAllUsers(){
        ApiResponse response = service.getAllUsers();
        return response.buildResponse(gson);
    }
}
