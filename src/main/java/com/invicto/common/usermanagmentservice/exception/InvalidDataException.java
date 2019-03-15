package com.invicto.common.usermanagmentservice.exception;

public class InvalidDataException extends Exception{
    public InvalidDataException(String fieldName) {
        super("Invalid Data "+fieldName);
    }
}
