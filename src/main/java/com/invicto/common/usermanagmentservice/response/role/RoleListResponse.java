package com.invicto.common.usermanagmentservice.response.role;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.entity.Role;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RoleListResponse extends ApiResponse {

    private List<Role> roles ;

    public RoleListResponse(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new ResponseEntity<>(gson.toJson(roles), HttpStatus.OK);
    }
}
