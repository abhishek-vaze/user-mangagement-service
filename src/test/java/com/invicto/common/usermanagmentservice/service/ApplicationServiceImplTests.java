package com.invicto.common.usermanagmentservice.service;


import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.Role;
import com.invicto.common.usermanagmentservice.repository.ApplicationRepository;
import com.invicto.common.usermanagmentservice.request.application.ApplicationCreationRequest;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import com.invicto.common.usermanagmentservice.service.impl.ApplicationServiceImpl;
import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@RunWith(JUnit4.class)
public class ApplicationServiceImplTests {

    @InjectMocks
    private ApplicationServiceImpl testObject;

    @Mock
    private Validator emailValidator =  Mockito.mock(EmailValidator .class);;

    @Mock
    private Gson gson = Mockito.mock(Gson.class);

    @Mock
    private ApplicationRepository appRepo = Mockito.mock(ApplicationRepository.class);

    private Application actualApplication,expectedApplication;

    @BeforeClass
    public void setupMocks(){
        // mocking email validator

        Mockito.when(emailValidator.validateString("test@test.com")).thenReturn(true); //positive
        Mockito.when(emailValidator.validateString("test.com")).thenReturn(false); //negetive
        Mockito.when(appRepo.save(expectedApplication)).thenReturn(expectedApplication);

    }
    @Before
    public void setTestObject(){
        expectedApplication = new Application();
        expectedApplication.setApplicationOwnerName("Test T");
        expectedApplication.setApplicationOwnerEmailId("test@test.com");
        expectedApplication.setApplicationGolbalId("TESTAPP01");
        expectedApplication.setApplicationId(1);
        expectedApplication.setApplicationName("TestApplication");
        Role role1 = new Role();
        role1.setRoleDescription("ADMIN");
        role1.setRoleId(1);
        expectedApplication.addRole(role1);

    }

    @Test
    public void testCreateNewApplication(){
        ApplicationCreationRequest request = new ApplicationCreationRequest();
        request.setApplicationGolbalId("TESTAPP01");
        request.setApplicationName("TestApplication");
        request.setOwnerEmailId("test@test.com");
        request.setOwnerName("Test T");
        RoleRequest role = new RoleRequest();
        role.setActive(true);
        role.setRoleDescription("ADMIN");
        request.setRoles(new RoleRequest[]{role});

        testObject.createNewApplication(request);

    }


}
