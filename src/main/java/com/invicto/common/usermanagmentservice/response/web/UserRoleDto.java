package com.invicto.common.usermanagmentservice.response.web;

import com.invicto.common.usermanagmentservice.entity.UserDetail;

public class UserRoleDto {
    private UserDetail userDetail;
    private String roleDescription;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
