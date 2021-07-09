package com.example.securityexample.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority {

    @Id
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private List<UserImpl> users;


    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nameRole;
    }
}