package com.nab.se.testIntegration.nonFunctional.validators;

import com.nab.se.testIntegration.nonFunctional.configuration.ConfigurationReader;
import com.nab.se.testIntegration.nonFunctional.exceptions.EnvironmentValidationException;
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
