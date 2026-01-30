package com.traveldestination.planner.user.controller;

import com.traveldestination.planner.user.model.response.GetApprovedDestinationsResponse;
import com.traveldestination.planner.user.model.response.GetUserUnApprovedDestinationsResponse;
import com.traveldestination.planner.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.traveldestination.planner.common.Constant.HttpConstant.USER_ID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @GetMapping("/approved-destinations")
    public GetApprovedDestinationsResponse getApprovedDestinations(
            @RequestHeader(USER_ID) Long userId) {

        return userService.getApprovedDestinations(userId);
    }

    @GetMapping("/unapproved-destinations")
    public List<GetUserUnApprovedDestinationsResponse> getUnApprovedDestinations(
            @RequestHeader(USER_ID) Long userId) {

        return userService.getUnApprovedDestinations(userId);
    }



}
