package com.invicto.common.usermanagmentservice.request;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.user.UserRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class UserCreationRequestTests {

    private UserRequest testObject;
    private Gson gson = new Gson();

    @Before
    public void setTestObject() {
        testObject = new UserRequest();
        testObject.setPassword("password123");
        testObject.setUserName("abhishekvaze");
    }

    @Test
    public void testNewUserRequestToJson() {
        String gsonString = testObject.toJson(gson);
        UserRequest deserializedObject = gson.fromJson(gsonString, UserRequest.class);
        Assert.assertEquals(deserializedObject, testObject);
    }


    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForUserName() throws Exception {
        testObject.setUserName(null);
        testObject.validate(null);
    }


    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryValidationForPassword() throws Exception {
        testObject.setPassword(null);
        testObject.validate(null);
    }

}
