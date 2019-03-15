package com.invicto.common.usermanagmentservice.repository;

import com.invicto.common.usermanagmentservice.entity.Application;
import com.invicto.common.usermanagmentservice.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Integer> {
    public Application findByApplicationId(int applicationId);
    public List<Application> findByApplicationOwnerEmailId(String applicationOwnerEmailId);
    public List<Application> findByApplicationNameLike(String applicationName);
    public Application findByApplicationGolbalId(String globalApplicationId);
}
