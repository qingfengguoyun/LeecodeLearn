package com.myProject_2024_02_08.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mydata")
public class myConfig {
    String testStr;
}
