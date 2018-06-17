package com.phoenix.shop.rest.controller;

import com.phoenix.shop.model.response.RegionResponse;
import com.phoenix.shop.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/regions")
@Api("Region controller")
@CrossOrigin
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(final RegionService regionService) {
        this.regionService = regionService;
    }

    @PermitAll
    @GetMapping
    @ApiOperation("Find all regions")
    List<RegionResponse> findAll() {
        return regionService.findAll();
    }
}
