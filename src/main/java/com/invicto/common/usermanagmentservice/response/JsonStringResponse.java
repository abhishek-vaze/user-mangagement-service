package com.invicto.common.usermanagmentservice.response;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonStringResponse extends ApiResponse{

    private Object json;

    public JsonStringResponse(Object json) {
        this.json = json;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new ResponseEntity<String>(gson.toJson(json),HttpStatus.OK);
    }
}
