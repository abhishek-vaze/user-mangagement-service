package com.invicto.common.usermanagmentservice.service.impl;

import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.ApplicationRoles;
import com.invicto.common.usermanagmentservice.entity.UserDetail;
import com.invicto.common.usermanagmentservice.exception.ApplicationNotFoundException;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.exception.UserAlreadyExistException;
import com.invicto.common.usermanagmentservice.exception.UserNotFoundException;
import com.invicto.common.usermanagmentservice.repository.ApplicationRolesRepository;
import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.user.UserRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.response.ExceptionResponse;
import com.invicto.common.usermanagmentservice.response.JsonStringResponse;
import com.invicto.common.usermanagmentservice.response.user.UserCreationResponse;
import com.invicto.common.usermanagmentservice.response.user.UserDeletionResponse;
import com.invicto.common.usermanagmentservice.response.user.UserListResponse;
import com.invicto.common.usermanagmentservice.response.user.UserUpdationResponse;
import com.invicto.common.usermanagmentservice.response.web.UserRoleDto;
import com.invicto.common.usermanagmentservice.response.web.UserRoleDtoListResponse;
import com.invicto.common.usermanagmentservice.service.ApplicationService;
import com.invicto.common.usermanagmentservice.service.UserSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("userServiceBean")
public class UserServiceImpl implements UserSevrice {

    @Autowired
    private UserDetailRepository userRepo;

    @Autowired
    private ApplicationService appService;

    @Autowired
    private ApplicationRolesRepository appRoleRepo;

    @Override
    public ApiResponse createNewUser(ApiRequest request) {
        UserRequest userRequest;
        try {
            userRequest = validateUserCreationRequest((UserRequest) request);
            UserDetail userDetail = userRepo.findByUserName(userRequest.getUserName());
            if(userDetail == null) {
                userDetail = new UserDetail();
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
        catch(MandatoryValueNotFoundException ex){
            return new ExceptionResponse(ex,this.getClass().getName());
        }

    }

    @Override
    public ApiResponse removeUser(int id) {
        userRepo.deleteById(id);
        return new UserDeletionResponse();

    }

    @Override
    public ApiResponse updatePassword(ApiRequest request) {

        UserRequest userRequest;

        try {
            userRequest = validateUserCreationRequest((UserRequest) request);
        }
        catch(Exception ex){
            return new ExceptionResponse(ex,this.getClass().getName());
        }
        UserDetail userDetail = userRepo.findByUserName(userRequest.getUserName());
        if(userDetail == null) {
            userDetail.setPassword(userRequest.getPassword());
            userDetail.setLastPasswordChangedDate(new Date());
            userDetail.setLocked(false);
            userRepo.save(userDetail);
            return new UserUpdationResponse();
        }
        else
            return new ExceptionResponse(new UserNotFoundException(),this.getClass().getName());

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
    public ApiResponse getAllUsersByApplicationId(int id){

        Application application = appService.findApplicationById(id);
        List<UserRoleDto> userDetailList = new LinkedList<>();
        if(Objects.nonNull(application)){
            for (ApplicationRoles appRole: application.getRoles()) {
                for (UserDetail user:appRole.getUser()) {
                    UserRoleDto dto = new UserRoleDto();
                    dto.setUserDetail(user);
                    dto.setRoleDescription(appRole.getRole().getRoleDescription());
                    userDetailList.add(dto);
                }

            }
            return new UserRoleDtoListResponse(userDetailList);
        }
        else
            return new ExceptionResponse(new ApplicationNotFoundException(),this.getClass().getName());

    }

    @Override
    public ApiResponse findUserById(int id) {
        Optional<UserDetail> detail =  userRepo.findById(id);
        if(detail.isPresent())
            return new JsonStringResponse(detail.get());
        else
            return new ExceptionResponse(new UserNotFoundException(),this.getClass().getName());
    }

    private UserRequest validateUserCreationRequest(UserRequest request) throws MandatoryValueNotFoundException{
        request.validate(null);
        return request;
    }

}
