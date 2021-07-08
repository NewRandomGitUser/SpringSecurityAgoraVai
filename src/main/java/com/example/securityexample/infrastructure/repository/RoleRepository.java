package com.example.securityexample.infrastructure.repository;

import com.example.securityexample.infrastructure.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role, String> {
}
