package com.nab.se.helloWorld.test.integration.stepdefinitions;

import com.nab.se.helloWorld.Application;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@SpringBootTest
@Getter
public abstract class StepDefinition {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${endpoints.serverAddress}")
    private String serverAddress;
}
