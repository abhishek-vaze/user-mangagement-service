package com.invicto.common.usermanagmentservice.response.user;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.UserDetail;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserListResponse extends ApiResponse {

    private List<UserDetail> userDetailList;

    public UserListResponse(List<UserDetail> userDetailList) {
        this.userDetailList = userDetailList;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new ResponseEntity<>(gson.toJson(userDetailList), HttpStatus.OK);
    }

    public List<UserDetail> getUserDetailList() {
        return userDetailList;
    }
}
