package com.invicto.common.usermanagmentservice.request.user;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.util.StringUtils;


public class UserRequest extends ApiRequest {


    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate(Validator valid) throws MandatoryValueNotFoundException {
        if (StringUtils.isEmpty(getUserName())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("userName");
        }
        if (StringUtils.isEmpty(getPassword())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("password");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequest that = (UserRequest) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toJson(Gson gson) {
        return gson.toJson(this);
    }
}
