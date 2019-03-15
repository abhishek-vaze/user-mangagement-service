package com.invicto.common.usermanagmentservice.repository;

import com.invicto.common.usermanagmentservice.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail,Integer> {

    public UserDetail findByUserName(String userName);

}
