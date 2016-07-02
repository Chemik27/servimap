package com.tpfinal.service;

import com.tpfinal.security.CustomUserDetails;
import com.tpfinal.domain.User;
import com.tpfinal.repository.IUserRepository;
import com.tpfinal.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Datos incorrectos, intente nuevamente.");
        }else{
            List<String> userRoles = userRoleRepository.findRoleByIdUser(user.getIdUser());
            return new CustomUserDetails(user,userRoles);
        }
    }
}
