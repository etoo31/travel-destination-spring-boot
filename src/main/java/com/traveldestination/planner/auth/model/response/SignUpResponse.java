package com.traveldestination.planner.auth.model.response;

import lombok.Data;

@Data
public class SignUpResponse {
    private Long id;
    private  String email;
    private String name;
    private String userRole;
}
