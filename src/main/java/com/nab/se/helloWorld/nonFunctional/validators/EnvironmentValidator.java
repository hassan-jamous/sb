package com.nab.se.helloWorld.nonFunctional.validators;

import com.nab.se.helloWorld.nonFunctional.configuration.ConfigurationReader;
import com.nab.se.helloWorld.nonFunctional.exceptions.EnvironmentValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentValidator {

    @Autowired
    private ConfigurationReader configurationReader;

    public void validateEnvironment() {
        if (this.configurationReader.getJsonPlaceHolderDomain().equals("")) {
            throw new EnvironmentValidationException();
        }
    }
}
