package com.invicto.common.usermanagmentservice.request.role;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.util.StringUtils;

public class RoleRequest extends ApiRequest {

    private String roleDescription;
    private boolean isActive = true;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toJson(Gson gson) {
        return gson.toJson(this);
    }

    @Override
    public void validate(Validator validator) throws Exception {
        if (StringUtils.isEmpty(getRoleDescription())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("roleDescription");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleRequest request = (RoleRequest) o;

        if (isActive != request.isActive) return false;
        return roleDescription.equals(request.roleDescription);
    }

    @Override
    public int hashCode() {
        int result = roleDescription.hashCode();
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }
}
