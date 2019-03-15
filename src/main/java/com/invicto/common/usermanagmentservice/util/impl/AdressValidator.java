package com.invicto.common.usermanagmentservice.util.impl;

import com.invicto.common.usermanagmentservice.util.Validator;

public class AdressValidator extends Validator {

    final String ADRESS_VALIDATION_REGEX = "";

    private  Boolean validateStringForAdress(String string) {
        return null;
    }


    @Override
    public Boolean validateString(String string) {
        return validateStringForAdress(string);
    }
}
