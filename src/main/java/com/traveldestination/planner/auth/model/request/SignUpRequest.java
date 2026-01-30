package com.traveldestination.planner.auth.model.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String password;
    private String userName;
}
