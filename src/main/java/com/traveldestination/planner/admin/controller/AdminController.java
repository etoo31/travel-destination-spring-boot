package com.traveldestination.planner.admin.controller;

import com.traveldestination.planner.admin.model.PendingDestinationResponse;
import com.traveldestination.planner.admin.service.AdminService;
import com.traveldestination.planner.common.model.Destination;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.traveldestination.planner.common.Constant.HttpConstant.USER_ID;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/approve-destinations")
    public void approveDestination(
            @RequestHeader(USER_ID) long userId,
            @RequestBody Destination destination
            ) {

        adminService.approveDestination(userId, destination);
    }

    @PostMapping("/approve-multiple-destinations")
    public void approveMultipleDestinations(
            @RequestHeader(USER_ID) long userId,
            @RequestBody List<Destination> destinations
    ) {

        adminService.approveMultipleDestinations(userId, destinations);
    }

    @PostMapping("/remove-destination")
    public void removeDestination(
            @RequestHeader(USER_ID) long userId,
            @RequestBody Destination destination
    ) {
        adminService.removeDestination(userId, destination);
    }

    @GetMapping("/pending-destinations")
    public List<PendingDestinationResponse> getPendingDestination(
            @RequestHeader(USER_ID) long userId
    ) {
        return adminService.getPendingDestination(userId);
    }
}
