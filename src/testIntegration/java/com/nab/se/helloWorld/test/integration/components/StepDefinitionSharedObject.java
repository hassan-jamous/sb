package com.nab.se.helloWorld.test.integration.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@Setter
public class StepDefinitionSharedObject {
    private String userId;

    @PostConstruct
    public void initializeObjects() {

    }

    public void reInitialize() {
        this.userId = null;

    }
}