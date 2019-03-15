package com.invicto.common.usermanagmentservice.response.user;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserCreationResponse extends ApiResponse {

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
