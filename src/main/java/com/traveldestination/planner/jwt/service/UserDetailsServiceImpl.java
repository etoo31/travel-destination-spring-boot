package com.traveldestination.planner.jwt.service;

import com.traveldestination.planner.common.model.entity.UserEntity;
import com.traveldestination.planner.common.respository.jpa.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userRepository.findFirstByUsername(username);
        if(optionalUser.isEmpty()) throw new UsernameNotFoundException("Username not found", null);
        return new org.springframework.security.core.userdetails.User(optionalUser.get().getUsername(),optionalUser.get().getPassword(),
                new ArrayList<>());
    }
}
