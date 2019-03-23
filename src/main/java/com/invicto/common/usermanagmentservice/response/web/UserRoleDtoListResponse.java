package com.invicto.common.usermanagmentservice.response.web;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserRoleDtoListResponse extends ApiResponse {

    private List<UserRoleDto> dto;

    public UserRoleDtoListResponse(List<UserRoleDto> dto) {
        this.dto = dto;
    }

    public List<UserRoleDto> getDto() {
        return dto;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return null;
    }
}
