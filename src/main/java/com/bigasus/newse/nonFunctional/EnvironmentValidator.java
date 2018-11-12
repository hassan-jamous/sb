package com.bigasus.newse.nonFunctional;

import com.bigasus.newse.nonFunctional.configuration.ConfigurationReader;
import com.bigasus.newse.nonFunctional.exception.EnvironmentValidationException;
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
