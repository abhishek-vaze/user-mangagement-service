package com.invicto.common.usermanagmentservice.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "APPLICATION", indexes = {@Index(name = "idx_applicationname",  columnList="APPLICATION_NAME", unique = true)})
public class Application {

    @Id
    @Column(name = "APPLICATION_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="application_seq_gen")
    @SequenceGenerator(name="application_seq_gen", sequenceName="APPLICATION_SEQ")
    @Expose
    private int applicationId;
    @Column(name = "APPLICATION_OWNER_EMAIL_ID")
    @Expose
    private String applicationOwnerEmailId;
    @Column(name = "APPLICATION_OWNER_NAME")
    @Expose
    private String applicationOwnerName;
    @Column(name = "APPLICATION_NAME")
    @Expose
    private String applicationName;
    @Column(name = "APPLICATION_GLOBAL_ID")
    @Expose
    private String applicationGolbalId;

    @OneToMany(
            mappedBy = "application",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<ApplicationRoles> roles;

    public void addRole(Role role){
        ApplicationRoles roles = new ApplicationRoles(this,role);
        if(this.roles != null){
            this.roles.add(roles);
        }
        else{
            this.roles = new ArrayList<>();
            this.roles.add(roles);
        }



    }

    public void removeRole(Role role){
        for (Iterator<ApplicationRoles> iterator = roles.iterator();
             iterator.hasNext(); ) {
            ApplicationRoles postTag = iterator.next();

            if (postTag.getApplication().equals(this) &&
                    postTag.getRole().equals(role)) {
                iterator.remove();
                }
        }

    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationOwnerEmailId() {
        return applicationOwnerEmailId;
    }

    public void setApplicationOwnerEmailId(String applicationOwnerEmailId) {
        this.applicationOwnerEmailId = applicationOwnerEmailId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationGolbalId() {
        return applicationGolbalId;
    }

    public void setApplicationGolbalId(String applicationGolbalId) {
        this.applicationGolbalId = applicationGolbalId;
    }

    public String getApplicationOwnerName() {
        return applicationOwnerName;
    }

    public void setApplicationOwnerName(String applicationOwnerName) {
        this.applicationOwnerName = applicationOwnerName;
    }

    public List<ApplicationRoles> getRoles() {
        return roles;
    }
}
