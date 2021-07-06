package com.example.securityexample.repository;

import com.example.securityexample.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, String> {
}
