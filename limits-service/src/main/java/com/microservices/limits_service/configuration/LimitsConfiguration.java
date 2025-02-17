package com.microservices.limits_service.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limits-service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitsConfiguration {
    private int maximum;
    private int minimum;
}
