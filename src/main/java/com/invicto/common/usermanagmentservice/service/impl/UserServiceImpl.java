package com.invicto.common.usermanagmentservice.service.impl;

import com.google.common.collect.Lists;
import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.UserDemographicData;
import com.invicto.common.usermanagmentservice.entity.UserDetail;
import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.response.ExceptionResponse;
import com.invicto.common.usermanagmentservice.response.application.ApplicationListResponse;
import com.invicto.common.usermanagmentservice.response.user.UserCreationResponse;
import com.invicto.common.usermanagmentservice.response.user.UserDeletionResponse;
import com.invicto.common.usermanagmentservice.response.user.UserListResponse;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userServiceBean")
class UserServiceImpl implements UserSevrice {

    @Autowired
    @Qualifier("emailValidatorBean")
    Validator emailValidator;

    @Autowired
    @Qualifier("adressValidatorBean")
    Validator adressValidator;

    @Autowired
    @Qualifier("mobileNumberValidatorBean")
    Validator mobileNumberValidator;

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

        UserDemographicData userData = new UserDemographicData();
        userData.setAdress(userRequest.getAdress());
        userData.setEmailId(userRequest.getEmailId());
        userData.setFirstName(userRequest.getFirstName());
        userData.setLastName(userRequest.getLastName());
        userData.setMobileNumber(userRequest.getMobileNumber());

        UserDetail userDetail = new UserDetail();
        userDetail.setUserName(userRequest.getUserName());
        userDetail.setPassword(userRequest.getPassword());
        userDetail.setLastPasswordChangedDate(new Date());
        userDetail.setLocked(false);
        userDetail.setUserDemographicData(userData);

        userRepo.save(userDetail);
        return new UserCreationResponse();
    }

    @Override
    public ApiResponse removeUser(int id) {
        userRepo.deleteById(id);
        return new UserDeletionResponse();

    }

    @Override
    public ApiResponse updateUser(int id, ApiRequest request) {
        return  null;

    }

    @Override
    public ApiResponse getAllUsersWithNameLike(String name) {
        return  null;

    }

    @Override
    public ApiResponse unlockUser(int id) {
        return  null;

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

    private UserCreationRequest validateUserCreationRequest(UserCreationRequest request) throws Exception{
        request.validate(emailValidator);
        request.validate(adressValidator);
        request.validate(mobileNumberValidator);
        return request;
    }

}
