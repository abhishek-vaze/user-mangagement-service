package com.invicto.common.usermanagmentservice.util.impl;

import com.invicto.common.usermanagmentservice.util.Validator;

public class MobileNumberValidator extends Validator {


    final String MOBILE_NUMBER_VALIDATION_REGEX = "";

    private  Boolean validateStringForMobileNumber(String string) {
        return null;
    }

    @Override
    public Boolean validateString(String string) {
        return validateStringForMobileNumber(string);
    }
}
