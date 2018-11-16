package com.nab.se.helloWorld.test.integration.configuration.testManager;


public class IntegrationTestManager implements TestManager {

    @Override
    public void prepareTestData() {
        System.out.println(" prepare test data ");
    }

    @Override
    public void initializeTest() {
        System.out.println(" initialize test ");
    }

    @Override
    public void endTest() {
        System.out.println(" finalize test ");
    }
}
