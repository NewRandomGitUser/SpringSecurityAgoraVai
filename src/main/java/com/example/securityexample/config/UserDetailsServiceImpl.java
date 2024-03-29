package com.example.securityexample.config;

import com.example.securityexample.models.MyUser;
import com.example.securityexample.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private MyUserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser usuario = ur.findByLogin(login);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }

}



