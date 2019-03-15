package com.invicto.common.usermanagmentservice.request.user;

import com.google.gson.Gson;
import com.invicto.common.usermanagmentservice.exception.InvalidDataException;
import com.invicto.common.usermanagmentservice.exception.MandatoryValueNotFoundException;
import com.invicto.common.usermanagmentservice.request.ApiRequest;
import com.invicto.common.usermanagmentservice.util.Validator;
import com.invicto.common.usermanagmentservice.util.impl.AdressValidator;
import com.invicto.common.usermanagmentservice.util.impl.EmailValidator;
import com.invicto.common.usermanagmentservice.util.impl.MobileNumberValidator;
import org.springframework.util.StringUtils;

public class UserCreationRequest extends ApiRequest {


    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String adress;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toJson(Gson gson) {

        return gson.toJson(this);
    }

    @Override
    public void validate(Validator valid) throws Exception {
        if (StringUtils.isEmpty(getUserName())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("userName");
        }
        if (StringUtils.isEmpty(getFirstName())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("firstName");
        }
        if (StringUtils.isEmpty(getMobileNumber())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("mobileNumber");
        }
        if (StringUtils.isEmpty(getPassword())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("password");
        }
        if (StringUtils.isEmpty(getAdress())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("adress");
        }
        if (StringUtils.isEmpty(getEmailId())) { //mandatory field validation
            throw new MandatoryValueNotFoundException("emailId");
        }
        if (valid instanceof EmailValidator){ // data validation controlled from outside through injection
            if(!valid.validateString(getEmailId())){
                throw new InvalidDataException("emailId");
            }
        }
        if (valid instanceof MobileNumberValidator){ // data validation controlled from outside through injection
            if(!valid.validateString(getMobileNumber())){
                throw new InvalidDataException("mobileNumber");
            }
        }
        if (valid instanceof AdressValidator){ // data validation controlled from outside through injection
            if(!valid.validateString(getAdress())){
                throw new InvalidDataException("adress");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCreationRequest that = (UserCreationRequest) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
        if (emailId != null ? !emailId.equals(that.emailId) : that.emailId != null) return false;
        return adress.equals(that.adress);
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (emailId != null ? emailId.hashCode() : 0);
        result = 31 * result + adress.hashCode();
        return result;
    }
}
