package com.invicto.common.usermanagmentservice.service;

import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;

public interface ApplicationService {
    public ApiResponse createNewApplication(ApiRequest request);
    public ApiResponse removeApplication(int id);
    public ApiResponse updateApplication(int id,ApiRequest request);
    public ApiResponse addRolesToApplication(int id,ApiRequest request);
    public ApiResponse removeRoleOfApplication(int id,int roleId);
    public ApiResponse getAllApplications();
    public ApiResponse getApplicationRoles(int id);
}
