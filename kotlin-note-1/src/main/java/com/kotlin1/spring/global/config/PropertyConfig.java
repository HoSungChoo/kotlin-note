package com.kotlin1.spring.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
        @PropertySource("classpath:properties/env.properties")
)
public class PropertyConfig {
}
