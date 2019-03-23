package com.invicto.common.usermanagmentservice.repository;

import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.ApplicationRoles;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRolesRepository extends CrudRepository<ApplicationRoles,Integer> {
}
