package com.nab.se.helloWorld.test.feature.configuration.testManager;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.nab.se.helloWorld.Application;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class StubbedFeatureTestManager implements FeatureTest {
    private static WireMockServer wireMockServer;

    @Override
    public void prepareTestData() {

    }

    @Override
    public void initializeTest() {
        startService();
        startWireMock();
    }

    @Override
    public void endTest() {
        wireMockServer.stop();
    }

    private void startWireMock() {
        wireMockServer = new WireMockServer(wireMockConfig()
                .port(8089)
                .httpsPort(8443)
                .fileSource(new ClasspathFileSource("src/featureTest/resources/wiremock"))
                .notifier(new ConsoleNotifier(true))
        );

        wireMockServer.start();
    }

    private void startService() {
        Application.main(new String[]{});
    }
}
