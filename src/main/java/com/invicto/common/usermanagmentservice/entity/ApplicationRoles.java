package com.invicto.common.usermanagmentservice.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "APPLICATION_ROLE")
public class ApplicationRoles implements Serializable {

    @Id
    @Column(name = "APPLICATION_ROLE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="application_roles_seq_gen")
    @SequenceGenerator(name="application_roles_seq_gen", sequenceName="APPLICATION_ROLES_SEQ")
    private int applicationRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    private Application application;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<UserDetail> user;

    public ApplicationRoles() {    }

    public ApplicationRoles(Application application, Role role) {
        this.application = application;
        this.role = role;
    }

    public Application getApplication() {
        return application;
    }

    public Role getRole() {
        return role;
    }

}
