package com.nab.se.testIntegration.cucumber.component;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Getter
@Setter
public class CommonObjects {
    private String userId;
    private String adviserId;
    private String clientId;

    @PostConstruct
    public void initializeObjects() {

    }

    public void reInitialize() {
        this.userId = null;
        this.adviserId = null;
        this.clientId = null;
    }
}