package com.invicto.common.usermanagmentservice.controller;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.request.application.ApplicationCreationRequest;
import com.invicto.common.usermanagmentservice.request.application.ApplicationUpdationRequest;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @Autowired
    private Gson gson;

    @GetMapping
    public ResponseEntity<String> getAllApplicationList(){
        ApiResponse response = service.getAllApplications();
        return response.buildResponse(gson);
    }

    @PostMapping
    public ResponseEntity<String> addNewApplication(@RequestBody ApplicationCreationRequest request){
        ApiResponse response = service.createNewApplication(request);
        return response.buildResponse(gson);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeApplication(@PathVariable String id){
        ApiResponse response = service.removeApplication(Integer.parseInt(id));
        return response.buildResponse(gson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable String id,@RequestBody ApplicationUpdationRequest request){
         ApiResponse response = service.updateApplication(Integer.parseInt(id),request);
         return response.buildResponse(gson);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addApplicationRoles(@PathVariable String id, @RequestBody RoleRequest request){
       ApiResponse response = service.addRolesToApplication(Integer.parseInt(id),request);
       return response.buildResponse(gson);
    }

    @DeleteMapping("/{id}/{roleId}")
    public ResponseEntity<String> removeApplicationRoles(@PathVariable String id,@PathVariable String roleId){
        ApiResponse response = service.removeRoleOfApplication(Integer.parseInt(id),Integer.parseInt(roleId));
        return response.buildResponse(gson);
    }

    @GetMapping("{id}/roles")
    public ResponseEntity<String> getApplicationRoles(@PathVariable String id){
        ApiResponse response = service.getApplicationRoles(Integer.parseInt(id));
        return response.buildResponse(gson);
    }

}
