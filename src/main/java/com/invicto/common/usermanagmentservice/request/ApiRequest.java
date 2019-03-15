package com.invicto.common.usermanagmentservice.request;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.util.Validator;

public abstract class ApiRequest {

    public abstract String toJson(Gson gson);
    public abstract void validate(Validator validator) throws Exception;

}
