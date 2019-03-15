package com.invicto.common.usermanagmentservice.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="role_seq_gen")
    @SequenceGenerator(name="role_seq_gen", sequenceName="ROLE_SEQ")
    @Expose
    private int roleId;
    @Column(name = "ROLE_DESCRIPTION")
    @Expose
    private String roleDescription;
    @Column(name = "IS_ACTIVE")
    @Expose
    private Boolean isActive;
    @Column(name = "CREATED_AT")
    @Expose
    private Date createdAt;
    @Column(name = "CREATED_BY")
    @Expose
    private String createdBy;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ApplicationRoles> applications;



    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
