package com.nab.se.testIntegration.configuration.hooks;

import com.nab.se.testIntegration.cucumber.component.CommonObjects;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalHooks {
    @Autowired
    private CommonObjects commonObjects;

    @Before
    public void beforeAll() {
        commonObjects.reInitialize();
    }

}
