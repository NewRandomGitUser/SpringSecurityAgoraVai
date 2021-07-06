package com.example.securityexample.controller;

import com.example.securityexample.models.MyUser;
import com.example.securityexample.models.Role;
import com.example.securityexample.repository.MyUserRepository;
import com.example.securityexample.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final MyUserRepository repository;

    private final RoleRepository roleRepository;

    @GetMapping("/")
    String getDefaultData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if(currentPrincipalName!="null")
        {   MyUser user = repository.findByLogin(currentPrincipalName);
            for (Role role : user.getRoles()) {
                System.out.println(role.getNomeRole());
            }
            return currentPrincipalName;}
        return "ok";
    }

    @GetMapping("/register")
    String getDefaultRegister() {
        Role role = new Role();
        role.setNomeRole("ROLE_ADMIN");
        roleRepository.save(role);
        MyUser myUser = new MyUser();
        myUser.setLogin("Asas");
        myUser.setNomeCompleto("Asas");
        myUser.setSenha( new BCryptPasswordEncoder().encode("123"));
        myUser.setRoles(Arrays.asList(role));
        repository.save(myUser);
        return "ok";
    }

    @GetMapping("/testeRoleAdmin")
    String getData() {
        return "ok";
    }

    @GetMapping("/testeRoleNotAdmin")
    String getData2() {
        return "ok";
    }
    @GetMapping("/testeRoleAdmin2")
    String getData3() {
        return "ok";
    }






}
