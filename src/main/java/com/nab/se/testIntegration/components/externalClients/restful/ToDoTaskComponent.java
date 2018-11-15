package com.nab.se.testIntegration.components.externalClients.restful;

import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.testIntegration.nonFunctional.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ToDoTaskComponent {

    @Value("${endpoints.jsonPlaceHolderDomain}")
    private String jsonPlaceHolderEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public Task getTask(int taskId) {
        Task response = restTemplate.getForObject(
                jsonPlaceHolderEndpoint + taskId, Task.class);
        this.validateTask(response);
        return response;
    }

    private void validateTask(Task task) {
        if(task.getTitle().equals("")) {
            throw new ValidationException();
        }
    }

}

