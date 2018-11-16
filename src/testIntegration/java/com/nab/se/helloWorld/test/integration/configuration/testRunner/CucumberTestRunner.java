package com.nab.se.helloWorld.test.integration.configuration.testRunner;

import com.nab.se.helloWorld.test.integration.configuration.testManager.TestManager;
import com.nab.se.helloWorld.test.integration.configuration.testManager.IntegrationTestManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/testIntegration/resources",
        glue = {"com.nab.se.helloWorld.test.integration"})
public final class CucumberTestRunner {
    static final TestManager integrationTest = new IntegrationTestManager();

    private CucumberTestRunner() {
    }

    @BeforeClass
    public static void prepare() {
        integrationTest.prepareTestData();
        integrationTest.initializeTest();
    }

    @AfterClass
    public static void end() {
        integrationTest.endTest();
    }
}
