package com.phoenix.shop.rest.controller;

import com.phoenix.shop.model.request.SaveUserRequest;
import com.phoenix.shop.model.response.UserResponse;
import com.phoenix.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/users")
@Api("User controller")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/byId")
    @ApiOperation("Find one user by id")
    public UserResponse findById(@RequestParam("id") final Long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/byEmail/{email}")
    @ApiOperation("Find one user by email")
    public UserResponse findByEmail(@PathVariable("email") final String email) {
        return userService.findByEmail(email);
    }

    @PermitAll
    @PostMapping(path = "/save")
    @ApiOperation("Save new user")
    public Long save(@RequestBody SaveUserRequest user) {
        return userService.save(user);
    }
}
