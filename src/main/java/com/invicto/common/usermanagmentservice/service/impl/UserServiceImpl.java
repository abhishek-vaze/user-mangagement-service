package com.invicto.common.usermanagmentservice.service.impl;

import com.google.common.collect.Lists;
import com.invicto.common.usermanagmentservice.entity.UserDetail;
import com.invicto.common.usermanagmentservice.exception.UserAlreadyExistException;
import com.invicto.common.usermanagmentservice.exception.UserNotFoundException;
import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.response.ExceptionResponse;
import com.invicto.common.usermanagmentservice.response.JsonStringResponse;
import com.invicto.common.usermanagmentservice.response.user.UserCreationResponse;
import com.invicto.common.usermanagmentservice.response.user.UserDeletionResponse;
import com.invicto.common.usermanagmentservice.response.user.UserListResponse;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("userServiceBean")
class UserServiceImpl implements UserSevrice {

    @Autowired
    private UserDetailRepository userRepo;

    @Override
    public ApiResponse createNewUser(ApiRequest request) {
        UserCreationRequest userRequest;
        try {
            userRequest = validateUserCreationRequest((UserCreationRequest) request);
        }
        catch(Exception ex){
            return new ExceptionResponse(ex,this.getClass().getName());
        }
        UserDetail userDetail = userRepo.findByUserName(userRequest.getUserName());
        if(userDetail == null) {
            userDetail.setUserName(userRequest.getUserName());
            userDetail.setPassword(userRequest.getPassword());
            userDetail.setLastPasswordChangedDate(new Date());
            userDetail.setLocked(false);
            userRepo.save(userDetail);
            return new UserCreationResponse();
        }
        else
            return new ExceptionResponse(new UserAlreadyExistException(),this.getClass().getName());
    }

    @Override
    public ApiResponse removeUser(int id) {
        userRepo.deleteById(id);
        return new UserDeletionResponse();

    }

    @Override
    public ApiResponse updatePassword(int id, ApiRequest request) {
        return null;
    }

    @Override
    public ApiResponse unlockUser(int id) {
        Optional<UserDetail> user = userRepo.findById(id);
        if(user.isPresent()){
            UserDetail actualUser = user.get();
            actualUser.setLocked(false);
            return null;
        }
        else

        return  new ExceptionResponse(new UserNotFoundException(),this.getClass().getName());

    }

    @Override
    public ApiResponse addNewApplicationRoleToUser(int id, ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse removeApplicationRoleOfUser(int id,ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse getAllUsers(){
        Iterable userDetails = userRepo.findAll();
        List<UserDetail> myList = Lists.newArrayList(userDetails);
        return new UserListResponse(myList);
    }

    @Override
    public ApiResponse findUserById(int id) {
        Optional<UserDetail> detail =  userRepo.findById(id);
        if(detail.isPresent())
            return new JsonStringResponse(detail.get());
        else
            return new ExceptionResponse(new UserNotFoundException(),this.getClass().getName());
    }

    private UserCreationRequest validateUserCreationRequest(UserCreationRequest request) throws Exception{
        request.validate(null);
        return request;
    }

}
