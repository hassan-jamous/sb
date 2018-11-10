package com.bigasus.newse.components;

import com.bigasus.newse.domains.jsonPlaceHolderDomain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ToDoTaskComponent {
    public static final String COORDINATE_SERVICE_ENDPOINT = "https://jsonplaceholder.typicode.com/todos/";

    @Autowired
    private RestTemplate restTemplate;

    public Task getTask(int taskId) {
        return restTemplate.getForObject(
                COORDINATE_SERVICE_ENDPOINT + taskId, Task.class);
    }

}
