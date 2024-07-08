package com.microservices.limits_service.controller;

import com.microservices.limits_service.configuration.LimitsConfiguration;
import com.microservices.limits_service.model.Limits;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/limits")
public class LimitsController {
    private final LimitsConfiguration limitsConfiguration;
    @GetMapping
    public Limits returnLimits(){
        return new Limits(limitsConfiguration.getMaximum(), limitsConfiguration.getMinimum());
    }

}
