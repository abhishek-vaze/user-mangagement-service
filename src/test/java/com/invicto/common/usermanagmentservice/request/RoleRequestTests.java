package com.invicto.common.usermanagmentservice.request;


import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.role.RoleRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RoleRequestTests {

    private RoleRequest testObj ;
    private Gson gson = new Gson();

    @Before
    public void setup(){
        testObj = new RoleRequest();
        testObj.setRoleDescription("ADMIN");
        testObj.setActive(false);
    }
    @Test
    public void testNewRoleRequestJson() throws Exception{

        String roleRequestJson = gson.toJson(testObj);
        testObj.validate(null);
        RoleRequest deserialzedObject = gson.fromJson(roleRequestJson,RoleRequest.class);
        Assert.assertEquals(testObj,deserialzedObject);
    }
    @Test(expected = MandatoryValueNotFoundException.class)
    public void testMandatoryFieldDescription() throws Exception{
        testObj.setRoleDescription(null);
        testObj.validate(null);

    }
}
