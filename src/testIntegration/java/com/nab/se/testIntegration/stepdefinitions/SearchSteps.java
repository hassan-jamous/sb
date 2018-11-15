package com.nab.se.testIntegration.stepdefinitions;


import com.nab.se.testIntegration.domains.nabDomain.BigasusTask;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;

public class SearchSteps extends StepDefinition {
    private ResponseEntity<BigasusTask> searchResponse;

    @When("^client search for something$")
    public void clientSearchForSomething() throws Throwable {
        searchResponse = this.getRestTemplate().getForEntity("http://localhost:8080/todo/2", BigasusTask.class);
        System.out.println(searchResponse.getStatusCode());
    }

    @Then("^client receive result$")
    public void clientReceiveResult() throws Throwable {
        System.out.println("im there");

    }
}
