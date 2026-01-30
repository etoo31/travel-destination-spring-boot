package com.traveldestination.planner.auth.service;

import com.traveldestination.planner.auth.model.request.SignUpRequest;
import com.traveldestination.planner.auth.model.response.SignUpResponse;
import com.traveldestination.planner.common.model.entity.UserEntity;
import com.traveldestination.planner.common.respository.jpa.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignUpResponse createUser(SignUpRequest signupRequest) {
        UserEntity user = new UserEntity();


        user.setUsername(signupRequest.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setRole("user");
        UserEntity createdUser = userRepository.save(user);

        SignUpResponse userDto = new SignUpResponse();
        userDto.setId(createdUser.getId());

        return userDto;

    }

    public Boolean hasUserWithUserName(String userName) {
        return userRepository.findFirstByUsername(userName).isPresent();
    }

    @PostConstruct
    public void createAdminAccount() {
        Optional<UserEntity> adminAccount = userRepository.findFirstByUsername("admin");
        if (adminAccount.isEmpty()) {
            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setRole("admin");
            user.setPassword(bCryptPasswordEncoder.encode("admin123"));
            userRepository.save(user);
        }
    }

    @PostConstruct
    public void createUserAccount() {
        Optional<UserEntity> userAccount = userRepository.findFirstByUsername("user");
        if (userAccount.isEmpty()) {
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setRole("user");
            user.setPassword(bCryptPasswordEncoder.encode("user123"));
            userRepository.save(user);
        }
    }
}
