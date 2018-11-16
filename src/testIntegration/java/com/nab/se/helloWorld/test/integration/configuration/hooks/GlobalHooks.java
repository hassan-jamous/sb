package com.nab.se.helloWorld.test.integration.configuration.hooks;

import com.nab.se.helloWorld.test.integration.components.StepDefinitionSharedObject;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalHooks {
    @Autowired
    private StepDefinitionSharedObject stepDefinitionSharedObject;

    @Before
    public void beforeTest() {
        stepDefinitionSharedObject.reInitialize();
    }
}
