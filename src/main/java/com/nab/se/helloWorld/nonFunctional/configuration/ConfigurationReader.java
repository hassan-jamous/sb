package com.nab.se.helloWorld.nonFunctional.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ConfigurationReader {
    @Value("${endpoints.jsonPlaceHolderDomain}")
    private String jsonPlaceHolderDomain;
    @Value("${someConfiguration.value}")
    private String someConfigurationValue;
}
