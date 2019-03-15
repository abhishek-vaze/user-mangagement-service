package com.invicto.common.usermanagmentservice.response;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionResponse extends ApiResponse {

    private Exception ex;
    private String source;

    public ExceptionResponse(Exception ex,String source) {
        this.ex = ex;
    }

    @Override
    public ResponseEntity<String> buildResponse(Gson gson) {
        return new  ResponseEntity<String>(gson.toJson(new ExceptionMessage(ex.getMessage(),source)),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private class ExceptionMessage{
        private String errorMessage;
        private String source;

        public ExceptionMessage(String errorMessage, String source) {
            this.errorMessage = errorMessage;
            this.source = source;
        }
    }
}
