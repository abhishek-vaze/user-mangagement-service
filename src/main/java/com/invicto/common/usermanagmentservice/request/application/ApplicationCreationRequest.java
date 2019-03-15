package com.invicto.common.usermanagmentservice.request.application;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.InvalidDataException;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import org.springframework.util.StringUtils;

public class ApplicationCreationRequest extends ApiRequest {

    private String applicationName;
    private String applicationGolbalId;
    private String ownerName;
    private String ownerEmailId;
    private RoleRequest[] roles;

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

    public RoleRequest[] getRoles() {
        return roles;
    }

    public void setRoles(RoleRequest[] roles) {
        this.roles = roles;
    }

    @Override
    public String toJson(Gson gson) {
        return gson.toJson(this);
    }

    @Override
    public void validate(Validator validator) throws Exception {

        if (StringUtils.isEmpty(getApplicationName())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("applicationName");
        }
        if (StringUtils.isEmpty(getOwnerName())) {
            throw new MandatoryValueNotFoundException("ownerName");
        }
        if (StringUtils.isEmpty(getOwnerEmailId())) {
            throw new MandatoryValueNotFoundException("ownerEmailId");
        }
        if (validator instanceof EmailValidator) { //add as many validation as you can but controlled from outside
                if (!validator.validateString(getOwnerEmailId())) {
                    throw new InvalidDataException("ownerEmailId");
                }
            }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationCreationRequest that = (ApplicationCreationRequest) o;

        if (!applicationName.equals(that.applicationName)) return false;
        if (!applicationGolbalId.equals(that.applicationGolbalId)) return false;
        if (!ownerName.equals(that.ownerName)) return false;
        return ownerEmailId.equals(that.ownerEmailId);
    }

    @Override
    public int hashCode() {
        int result = applicationName.hashCode();
        result = 31 * result + applicationGolbalId.hashCode();
        result = 31 * result + ownerName.hashCode();
        result = 31 * result + ownerEmailId.hashCode();
        return result;
    }
}
