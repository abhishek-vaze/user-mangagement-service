package com.invicto.common.usermanagmentservice.service.impl;

import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceBean")
class UserServiceImpl implements UserSevrice {

    @Autowired
    private UserDetailRepository userRepo;

    @Override
    public ApiResponse createNewUser(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse removeUser(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse updateUser(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse getAllUsersWithNameLike(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse unlockUser(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse addNewApplicationRoleToUser(ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse removeApplicationRoleOfUser(ApiRequest request) {
        return  null;

    }
}
