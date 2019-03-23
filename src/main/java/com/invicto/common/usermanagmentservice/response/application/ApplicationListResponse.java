package com.invicto.common.usermanagmentservice.response.application;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ApplicationListResponse extends ApiResponse {

    private List<Application> applicationList;

    public ApplicationListResponse(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new ResponseEntity<String>(gson.toJson(applicationList), HttpStatus.OK);
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }
}
