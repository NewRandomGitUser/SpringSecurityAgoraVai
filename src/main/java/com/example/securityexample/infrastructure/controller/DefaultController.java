package com.example.securityexample.infrastructure.controller;

import com.example.securityexample.infrastructure.controller.request.RegistrationRequest;
import com.example.securityexample.infrastructure.controller.response.RegistrationResponse;
import com.example.securityexample.infrastructure.models.MyUser;
import com.example.securityexample.infrastructure.models.Role;
import com.example.securityexample.infrastructure.repository.MyUserRepository;
import com.example.securityexample.infrastructure.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
        myUser.setFullName("Asas");
        myUser.setPassword( new BCryptPasswordEncoder().encode("123"));
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

    //Parte mais sistematizada
    @GetMapping("/authentication")
    String authenticate() {
        return "ok";
    }

    @PostMapping("/user/registration")
    ResponseEntity<RegistrationResponse> registrate(@RequestBody RegistrationRequest request) {
        final var user = MyUser.builder()
                .fullName(request.getFullName())
                .login(request.getLogin())
                .password(request.getPassword())
                .build();
        repository.save(user);
        return ResponseEntity.ok(RegistrationResponse
                .builder()
                .fullName(user.getFullName())
                .login(user.getLogin())
                .build());
    }

    @GetMapping("/user/role")
    String attributeRole() {
        return "ok";
    }


    @GetMapping("/users")
    String listUsers() {
        return "ok";
    }

    @GetMapping("/users/{id}")
    String userById() {
        return "ok";
    }

    @GetMapping("/user/delete")
    String deleteUser() {
        return "ok";
    }








    //Criar usuário, deletar usuário, alterar role de acesso de usuário,

    //Listar usuários por diferentes critérios


    //validar em uma entity

//    @GetMapping("/api/v1/testeRoleAdmin2")
//    String getData3() {
//        return "ok";
//    }
}

