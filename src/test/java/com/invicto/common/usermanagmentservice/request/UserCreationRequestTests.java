package com.invicto.common.usermanagmentservice.request;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.user.UserCreationRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class UserCreationRequestTests {

    private UserCreationRequest testObject;
    private Gson gson = new Gson();

    @Before
    public void setTestObject() {
        testObject = new UserCreationRequest();
        testObject.setAdress("Twin Arcs, Punawale, Pune");
        testObject.setEmailId("abhishekvaze@ymail.com");
        testObject.setMobileNumber("9049998810");
        testObject.setPassword("password123");
        testObject.setFirstName("Abhishek");
        testObject.setLastName("Vaze");
        testObject.setUserName("abhishekvaze");
    }

    @Test
    public void testNewUserRequestToJson() {
        String gsonString = testObject.toJson(gson);
        UserCreationRequest deserializedObject = gson.fromJson(gsonString, UserCreationRequest.class);
        Assert.assertEquals(deserializedObject, testObject);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForFirstName() throws Exception {
        testObject.setFirstName(null);
        testObject.validate(null);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForUserName() throws Exception {
        testObject.setUserName(null);
        testObject.validate(null);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForAdress() throws Exception {
        testObject.setAdress(null);
        testObject.validate(null);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForMobileNumber() throws Exception {
        testObject.setMobileNumber(null);
        testObject.validate(null);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForPassword() throws Exception {
        testObject.setPassword(null);
        testObject.validate(null);
    }

    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForEmailId() throws Exception {
        testObject.setEmailId(null);
        testObject.validate(null);
    }
}
