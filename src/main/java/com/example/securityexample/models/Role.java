package com.example.securityexample.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private List<MyUser> users;

    public String getNomeRole() {
        return nameRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nameRole = nomeRole;
    }

    public List<MyUser> getUsuarios() {
        return users;
    }

    public void setUsuarios(List<MyUser> usuarios) {
        this.users = usuarios;
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nameRole;
    }
}