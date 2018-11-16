package com.nab.se.helloWorld.test.integration.stepdefinitions;

import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class SearchSteps extends StepDefinition {
    private ResponseEntity<NabTaskDomain> searchResponse;

    @When("^client search for something$")
    public void clientSearchForSomething() throws Throwable {
        searchResponse = this.getRestTemplate().getForEntity("http://localhost:8080/todo/2", NabTaskDomain.class);
    }

    @Then("^client receive result$")
    public void clientReceiveResult() throws Throwable {
        assertEquals(HttpStatus.OK, searchResponse.getStatusCode());
    }
}
