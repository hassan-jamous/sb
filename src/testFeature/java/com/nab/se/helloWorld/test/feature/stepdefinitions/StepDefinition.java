package com.nab.se.helloWorld.test.feature.stepdefinitions;

import com.nab.se.helloWorld.Application;
import lombok.Getter;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@Getter
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public abstract class StepDefinition {
    private RestTemplate restTemplate = new RestTemplate();
}
