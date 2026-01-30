package com.traveldestination.planner.auth.service;

import com.traveldestination.planner.auth.model.request.SignUpRequest;
import com.traveldestination.planner.auth.model.response.SignUpResponse;

public interface AuthService {
    SignUpResponse createUser (SignUpRequest signupRequest);
    Boolean hasUserWithUserName(String email);
}
