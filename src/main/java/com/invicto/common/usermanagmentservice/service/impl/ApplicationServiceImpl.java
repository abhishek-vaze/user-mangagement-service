package com.invicto.common.usermanagmentservice.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.ApplicationRoles;
import com.invicto.common.usermanagmentservice.entity.Role;
import com.invicto.common.usermanagmentservice.exception.ApplicationNotFoundException;
import com.invicto.common.usermanagmentservice.exception.NotFoundException;
import com.invicto.common.usermanagmentservice.repository.ApplicationRepository;
import com.invicto.common.usermanagmentservice.repository.RoleRepository;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.request.application.ApplicationCreationRequest;
import com.invicto.common.usermanagmentservice.request.application.ApplicationUpdationRequest;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import com.invicto.common.usermanagmentservice.response.ApiResponse;
import com.invicto.common.usermanagmentservice.response.ExceptionResponse;
import com.invicto.common.usermanagmentservice.response.application.ApplicationCreationResponse;
import com.invicto.common.usermanagmentservice.response.application.ApplicationDeletetionResponse;
import com.invicto.common.usermanagmentservice.response.application.ApplicationListResponse;
import com.invicto.common.usermanagmentservice.response.application.ApplicationUpdationResponse;
import com.invicto.common.usermanagmentservice.response.role.RoleListResponse;
import com.invicto.common.usermanagmentservice.response.role.RoleRemovalResponse;
import com.invicto.common.usermanagmentservice.service.ApplicationService;
import com.invicto.common.usermanagmentservice.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository appRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    @Qualifier("emailValidatorBean")
    private Validator emailValidator;

    @Autowired
    private Gson gson;

    @Override
    @Transactional
    public ApiResponse createNewApplication(ApiRequest request) {
        ApplicationCreationRequest validatedRequest;
        try {
            validatedRequest = validateRequest(request);
        } catch (Exception ex) {
            return new ExceptionResponse(ex,this.getClass().getName());
        }

        Application newApplication = new Application();
        newApplication.setApplicationGolbalId(validatedRequest.getApplicationGolbalId());
        newApplication.setApplicationName(validatedRequest.getApplicationName());
        newApplication.setApplicationOwnerEmailId(validatedRequest.getOwnerEmailId());
        newApplication.setApplicationOwnerName(validatedRequest.getOwnerName());
        RoleRequest[] roles = validatedRequest.getRoles();
        Arrays.stream(roles).forEach(role -> {
            Role applicationRole = roleRepo.findByRoleDescriptionAndIsActive(role.getRoleDescription(), true);
            if (applicationRole == null) {
                System.out.println("Role Not found creating new one");
                applicationRole = new Role();
                applicationRole.setRoleDescription(role.getRoleDescription());
                applicationRole.setActive(true);
            }
            newApplication.addRole(applicationRole);
        });
        appRepo.save(newApplication);
        return new ApplicationCreationResponse();
    }

    @Override
    public ApiResponse removeApplication(int id) {
        appRepo.deleteById(id);
        return new ApplicationDeletetionResponse();
    }

    @Override
    public ApiResponse updateApplication(int id, ApiRequest request) {
        Application application = appRepo.findByApplicationId(id);
        ApplicationUpdationRequest validatedRequest;
        if (application != null) {
            try {
                validatedRequest = validateRequestForUpdate(request);
                if (!StringUtils.isEmpty(validatedRequest.getApplicationGolbalId()))
                    application.setApplicationGolbalId(validatedRequest.getApplicationGolbalId());
                if (!StringUtils.isEmpty(validatedRequest.getApplicationName()))
                    application.setApplicationName(validatedRequest.getApplicationName());
                if (!StringUtils.isEmpty(validatedRequest.getOwnerEmailId()))
                    application.setApplicationOwnerEmailId(validatedRequest.getOwnerEmailId());
                if (!StringUtils.isEmpty(validatedRequest.getOwnerName()))
                    application.setApplicationOwnerName(validatedRequest.getOwnerName());
                appRepo.save(application);
                return new ApplicationUpdationResponse();

            } catch (Exception e) {
                return new ExceptionResponse(e,this.getClass().getName());
            }


        } else {
            return new ExceptionResponse(new NotFoundException("Application " + id),this.getClass().getName());
        }
    }

    @Override
    public ApiResponse addRolesToApplication(int id, ApiRequest request) {
        Application application = appRepo.findByApplicationId(id);
        RoleRequest validatedRequest;
        if (application != null) {
            try {
                validatedRequest = validateRoleRequest((RoleRequest) request);

                Role newRole = roleRepo.findByRoleDescriptionAndIsActive(validatedRequest.getRoleDescription(), true);
                if (newRole == null) {
                    newRole = new Role();
                    newRole.setRoleDescription(validatedRequest.getRoleDescription());
                    newRole.setCreatedBy("SYSTEM");
                    newRole.setActive(true);
                    newRole.setCreatedAt(new Date());
                }
                application.addRole(newRole);
                appRepo.save(application);
                return new ApplicationUpdationResponse();

            } catch (Exception ex) {
                return new ExceptionResponse(ex,this.getClass().getName());
            }

        } else {
            return new ExceptionResponse(new NotFoundException("Application " + id),this.getClass().getName());
        }
    }

    @Override
    public ApiResponse removeRoleOfApplication(int id, int roleId) {

        Application application = appRepo.findByApplicationId(id);
        if (application != null) {
            Optional<Role> role = roleRepo.findById(roleId);
            if (role.isPresent()) {
                application.removeRole(role.get());
                appRepo.save(application);
                return new RoleRemovalResponse();
            }
        }
        return new ExceptionResponse(new ApplicationNotFoundException(),this.getClass().getName());
    }

    @Override
    public ApiResponse getAllApplications() {
        Iterable applicationList = appRepo.findAll();
        List<Application> myList = Lists.newArrayList(applicationList);
        return new ApplicationListResponse(myList);
    }

    @Override
    public ApiResponse getApplicationRoles(int id) {
        Application application = appRepo.findByApplicationId(id);
        if (application == null) {
            return new ExceptionResponse(new ApplicationNotFoundException(),this.getClass().getName());
        } else {
            List<ApplicationRoles> appRoles = application.getRoles();
            List<Role> roles = appRoles.stream().map(ApplicationRoles::getRole).collect(Collectors.toList());
            return new RoleListResponse(roles);
        }
    }

    @Override
    public Application findApplicationById(int id) {
        Application application = appRepo.findByApplicationId(id);
        return application;
    }

    private ApplicationCreationRequest validateRequest(ApiRequest request) throws Exception {
        request.validate(emailValidator);
        return (ApplicationCreationRequest) request;
    }

    private ApplicationUpdationRequest validateRequestForUpdate(ApiRequest request) throws Exception {
        request.validate(emailValidator);
        return (ApplicationUpdationRequest) request;
    }

    private RoleRequest validateRoleRequest(RoleRequest request) throws Exception {
        request.validate(null);
        return request;
    }
}
