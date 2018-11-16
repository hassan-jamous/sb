package com.nab.se.helloWorld;

import com.nab.se.helloWorld.nonFunctional.validators.EnvironmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {
    @Autowired
    private EnvironmentValidator environmentValidator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void validateEnvironment() {
        this.environmentValidator.validateEnvironment();
    }
}
