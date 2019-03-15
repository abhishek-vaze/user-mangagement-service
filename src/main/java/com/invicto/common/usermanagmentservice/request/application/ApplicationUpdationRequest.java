package com.invicto.common.usermanagmentservice.request.application;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.InvalidDataException;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import org.springframework.util.StringUtils;


public class ApplicationUpdationRequest extends ApiRequest {

    private String applicationName;
    private String applicationGolbalId;
    private String ownerName;
    private String ownerEmailId;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationGolbalId() {
        return applicationGolbalId;
    }

    public void setApplicationGolbalId(String applicationGolbalId) {
        this.applicationGolbalId = applicationGolbalId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmailId() {
        return ownerEmailId;
    }

    public void setOwnerEmailId(String ownerEmailId) {
        this.ownerEmailId = ownerEmailId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toJson(Gson gson) {
        return gson.toJson(this);
    }

    @Override
    public void validate(Validator validator) throws Exception {
        if (!StringUtils.isEmpty(getOwnerEmailId())) {
            if (validator instanceof EmailValidator) { //add as many validation as you can but controlled from outside
                if (!validator.validateString(getOwnerEmailId())) {
                    throw new InvalidDataException("ownerEmailId");
                }
            }
        }
    }
}
