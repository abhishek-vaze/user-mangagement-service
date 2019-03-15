package com.invicto.common.usermanagmentservice.request;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.InvalidDataException;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.application.ApplicationCreationRequest;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class ApplicationCreationRequestTests {

    private ApplicationCreationRequest testObject;
    private Gson gson = new Gson();
    private EmailValidator validator = Mockito.mock(EmailValidator.class);

    @Before
    public void setTestObject(){
        testObject = new ApplicationCreationRequest();
        testObject.setApplicationGolbalId("MH15AOR12");
        testObject.setApplicationName("One Rates Enviroment");
        testObject.setOwnerName("William DCosta");
        testObject.setOwnerEmailId("test@test.com");
        RoleRequest[] requests = createTempRoleRequests();
        testObject.setRoles(requests);

        // mocking email validator

        Mockito.when(validator.validateString("test@test.com")).thenReturn(true); //positive
        Mockito.when(validator.validateString("test.com")).thenReturn(false); //negetive


    }
    private RoleRequest[] createTempRoleRequests(){
        RoleRequest[] requests = new RoleRequest[1];
        RoleRequest request1 = new RoleRequest();
        request1.setRoleDescription("ADMIN");
        request1.setActive(true);
        requests[0] = request1;
        RoleRequest request2 = new RoleRequest();
        request2.setRoleDescription("USER");
        request2.setActive(true);
        requests[0] = request2;
        return requests;
    }

    @Test
    public void testNewApplicationRequestJson(){
        String gsonString = testObject.toJson(gson);
        ApplicationCreationRequest deserializedObject = gson.fromJson(gsonString,ApplicationCreationRequest.class);
        Assert.assertEquals(deserializedObject,testObject);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryFieldValidationForApplicationName() throws Exception{

        testObject.setApplicationName(null);
        testObject.validate(null);
    }
    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryFieldValidationForOwnerName() throws Exception{
        testObject.setOwnerName(null);
        testObject.validate(null);

    }
    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryFieldValidationForOwnerEmail() throws Exception{
        testObject.setOwnerEmailId(null);
        testObject.validate(null);

    }
    @Test
    public void testOwnerEmailIdWithValidData() throws Exception{

        testObject.validate(validator);


    }
    @Test(expected = InvalidDataException.class)
    public void testOwnerEmailIdWithInValidData()throws Exception{
        testObject.setOwnerEmailId("test.com");
        testObject.validate(validator);

    }

}
