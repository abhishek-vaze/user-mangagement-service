package com.invicto.common.usermanagmentservice.service;

import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import io.swagger.annotations.Api;

public interface UserSevrice {

    public ApiResponse createNewUser(ApiRequest request);
    public ApiResponse removeUser(int id);
    public ApiResponse updatePassword(int id,ApiRequest request);
    public ApiResponse unlockUser(int id);
    public ApiResponse addNewApplicationRoleToUser(int id,ApiRequest request);
    public ApiResponse removeApplicationRoleOfUser(int id,ApiRequest request);
    public ApiResponse getAllUsers();
    public ApiResponse findUserById(int id);

}
