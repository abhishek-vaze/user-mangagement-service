package com.invicto.common.usermanagmentservice.repository;

import com.invicto.common.usermanagmentservice.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    public Role findByRoleDescription(String description);
    public Role findByRoleDescriptionAndIsActive(String description,Boolean isActive);
    public List<Role> findByIsActive(Boolean isActive);
    public List<Role> findByCreatedBy(String createdBy);
    public List<Role> findByRoleDescriptionLike(String RoleDescription);
}
