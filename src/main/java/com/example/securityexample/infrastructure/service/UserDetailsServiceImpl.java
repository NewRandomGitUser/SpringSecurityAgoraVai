package com.example.securityexample.infrastructure.service;

import com.example.securityexample.infrastructure.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private MyUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final var user = repository.findByLogin(login);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getAuthorities());
    }
}



