package com.invicto.common.usermanagmentservice.util.impl;

import com.invicto.common.usermanagmentservice.util.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator extends Validator {

    final String EMAIL_VALIDATION_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private Pattern pattern;
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_VALIDATION_REGEX,Pattern.CASE_INSENSITIVE);
    }

    private  Boolean validateStringForEmail(String string) {
        Matcher matcher = pattern.matcher(string);
        Boolean status = matcher.find();
        return status;
    }

    @Override
    public Boolean validateString(String string) {
        Boolean status =  validateStringForEmail(string);
        return status;
    }
}
