package com.invicto.common.usermanagmentservice.response;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;

public abstract class ApiResponse {

    public abstract ResponseEntity<String> buildResponse(Gson gson);
}
