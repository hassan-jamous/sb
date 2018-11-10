package com.bigasus.newse.components;

import com.bigasus.newse.domains.jsonPlaceHolderDomain.Task;
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
        return restTemplate.getForObject(
                jsonPlaceHolderEndpoint + taskId, Task.class);
    }

}
