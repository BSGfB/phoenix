package com.phoenix.shop.rest.controller;

import com.phoenix.shop.model.request.SaveUserRequest;
import com.phoenix.shop.model.response.UserResponse;
import com.phoenix.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api("User controller")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/byId")
    @ApiOperation("Find one user by id")
    UserResponse findById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping(path = "/save")
    @ApiOperation("Save new user")
    Long save(@RequestBody SaveUserRequest user) {
        return userService.save(user);
    }
}
