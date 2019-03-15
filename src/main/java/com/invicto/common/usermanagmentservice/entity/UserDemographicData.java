package com.invicto.common.usermanagmentservice.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_DEMOGRAPHIC_DATA",indexes = {@Index(name = "idx_userId",  columnList="USER_ID", unique = true)},uniqueConstraints= @UniqueConstraint(columnNames={"EMAIL_ID","MOBILE_NUMBER"}))
public class UserDemographicData implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserDetail userDetail;

    @Column(name = "FIRST_NAME")
    @Expose
    private String firstName;
    @Column(name = "LAST_NAME")
    @Expose
    private String lastName;
    @Column(name = "EMAIL_ID")
    @Expose
    private String emailId;
    @Column(name = "ADRESS")
    @Expose
    private String adress;
    @Column(name = "MOBILE_NUMBER")
    @Expose
    private String mobileNumber;

    public UserDemographicData() {

    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDemographicData that = (UserDemographicData) o;

        if (userDetail != null ? !userDetail.equals(that.userDetail) : that.userDetail != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (!emailId.equals(that.emailId)) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        return mobileNumber.equals(that.mobileNumber);
    }

    @Override
    public int hashCode() {
        int result = userDetail != null ? userDetail.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + emailId.hashCode();
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + mobileNumber.hashCode();
        return result;
    }
}
