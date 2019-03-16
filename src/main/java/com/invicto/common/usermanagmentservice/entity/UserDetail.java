package com.invicto.common.usermanagmentservice.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER_DETAIL",indexes = {@Index(name = "idx_username",  columnList="USER_NAME", unique = true)},uniqueConstraints= @UniqueConstraint(columnNames={"USER_NAME", "USER_ID"}))
public class UserDetail implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="user_detail_gen")
    @SequenceGenerator(name="user_detail_gen", sequenceName="USER_DETAIL_SEQ")
    @Expose
    private Integer userId;
    @Expose
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IS_LOCKED")
    private Boolean isLocked;
    @Column(name = "FAILED_LOGIN_COUNT")
    private int failedLoginCount;
    @Column(name = "LAST_PASSWORD_CHANGED_DATE")
    private Date lastPasswordChangedDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="USER_ID")
    private Set<LoginAttempts> logins;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private List<ApplicationRoles> applicationRoles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public Date getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }

    public void setLastPasswordChangedDate(Date lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }

    public Set<LoginAttempts> getLogins() {
        return logins;
    }

    public void setLogins(Set<LoginAttempts> logins) {
        this.logins = logins;
    }

}
