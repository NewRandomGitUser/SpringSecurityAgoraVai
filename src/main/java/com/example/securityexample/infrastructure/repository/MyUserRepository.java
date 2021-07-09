package com.example.securityexample.infrastructure.repository;

import com.example.securityexample.infrastructure.model.UserImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<UserImpl, String> {
    UserImpl findByLogin(String login);
}
