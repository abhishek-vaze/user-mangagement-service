package com.invicto.common.usermanagmentservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOGIN_ATTEMPTS")
public class LoginAttempts {
    @Id
    @Column(name = "LOGIN_ATTEMPT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="login_attempt_seq_gen")
    @SequenceGenerator(name="login_attempt_seq_gen", sequenceName="LOGIN_ATTEMPTS_SEQ")
    private String loginAttemptId;
    @Column(name = "ATTEMPTED_DATE")
    private Date attemptedDate;
    @Column(name = "STATUS")
    private Boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private UserDetail user;

    public LoginAttempts(String loginAttemptId, Date attemptedDate, Boolean status, UserDetail user) {
        this.loginAttemptId = loginAttemptId;
        this.attemptedDate = attemptedDate;
        this.status = status;
        this.user = user;
    }

    public String getLoginAttemptId() {
        return loginAttemptId;
    }

    public void setLoginAttemptId(String loginAttemptId) {
        this.loginAttemptId = loginAttemptId;
    }

    public Date getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(Date attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginAttempts that = (LoginAttempts) o;

        if (!loginAttemptId.equals(that.loginAttemptId)) return false;
        if (!attemptedDate.equals(that.attemptedDate)) return false;
        if (!status.equals(that.status)) return false;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = loginAttemptId.hashCode();
        result = 31 * result + attemptedDate.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
