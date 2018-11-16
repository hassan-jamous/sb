package com.nab.se.helloWorld.test.feature.configuration.testRunner;

import com.nab.se.helloWorld.test.feature.configuration.testManager.FeatureTest;
import com.nab.se.helloWorld.test.feature.configuration.testManager.IntegrationFeatureTestManager;
import com.nab.se.helloWorld.test.feature.configuration.testManager.StubbedFeatureTestManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/testFeature/resources",
        glue = {"com.nab.se.helloWorld.test.feature", "com.nab.nlinkweb.cucumber.configuration"})
public final class CucumberTestRunner {
    private static FeatureTest featureTest = CucumberTestRunner.giveMeFeatureTest(getCucumberTag());

    private CucumberTestRunner() {
    }

    public static String getCucumberTag() {
        return System.getProperties().getProperty("cucumber.options").replaceAll(".*@", "");
    }

    private static FeatureTest giveMeFeatureTest(String tag) {
        if (tag.equals("IntegrationTest")) {
            return new IntegrationFeatureTestManager();
        } else if (tag.equals("StubbedTest")) {
            return new StubbedFeatureTestManager();
        } else {
            throw new RuntimeException("We accept Integration or Stubbed, Wrong input to factory");
        }
    }

    @BeforeClass
    public static void prepare() {
        featureTest.prepareTestData();
        featureTest.initializeTest();
    }

    @AfterClass
    public static void end() {
        featureTest.endTest();
    }
}
