package com.invicto.common.usermanagmentservice.exception;

public class MandatoryValueNotFoundException extends Exception {

    public MandatoryValueNotFoundException(String fieldName) {
        super("Mandatory value not provided : "+fieldName);
    }
}
