package com.traveldestination.planner.user.controller;

import com.traveldestination.planner.user.model.response.UserFavoriteDestination;
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


    @GetMapping("/favorite")
    public UserFavoriteDestination getUserFavoriteDestinations(
            @RequestHeader(USER_ID) Long userId) {

        return userService.getUserFavoriteDestinations(userId);
    }

}
