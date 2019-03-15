package com.invicto.common.usermanagmentservice.service;

import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;

public interface UserSevrice {

    public ApiResponse createNewUser(ApiRequest request);
    public ApiResponse removeUser(ApiRequest request);
    public ApiResponse updateUser(ApiRequest request);
    public ApiResponse getAllUsersWithNameLike(ApiRequest request);
    public ApiResponse unlockUser(ApiRequest request);
    public ApiResponse addNewApplicationRoleToUser(ApiRequest request);
    public ApiResponse removeApplicationRoleOfUser(ApiRequest request);

}
