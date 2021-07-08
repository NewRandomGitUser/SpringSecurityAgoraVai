package com.example.securityexample.infrastructure.repository;

import com.example.securityexample.infrastructure.models.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, String> {

    MyUser findByLogin(String login);
}
