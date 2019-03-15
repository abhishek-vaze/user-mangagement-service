package com.invicto.common.usermanagmentservice.service;

import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;

public interface UserSevrice {

    public ApiResponse createNewUser(ApiRequest request);
    public ApiResponse removeUser(int id);
    public ApiResponse updateUser(int id,ApiRequest request);
    public ApiResponse getAllUsersWithNameLike(String name);
    public ApiResponse unlockUser(int id);
    public ApiResponse addNewApplicationRoleToUser(int id,ApiRequest request);
    public ApiResponse removeApplicationRoleOfUser(int id,ApiRequest request);
    public ApiResponse getAllUsers();

}
