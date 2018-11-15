package com.nab.se.testIntegration.components.externalClients.restful;

import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.testIntegration.nonFunctional.exceptions.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = { "endpoints.jsonPlaceHolderDomain=http://test.test/" })
public class ToDoTaskComponentTest {
    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    ToDoTaskComponent toDoTaskComponent;

    @Test
    public void It_Should_Return_Task_Object_When_Something() throws Exception {
        Task atask = new Task(3,4, "title", false);
        Mockito.when(restTemplate.getForObject("http://test.test/13", Task.class)).thenReturn(atask);
        Task task = toDoTaskComponent.getTask(13);
        Mockito.verify(restTemplate, Mockito.times(1)).getForObject("http://test.test/13", Task.class);
        assertEquals(atask.getUserId(), task.getUserId());
    }

    @Test(expected = ValidationException.class)
    public void It_Should_Throw_Validation_Exception_When_Return_Value_Is_Wrong() throws Exception {
        Task atask = new Task(3,4, "", false);
        Mockito.when(restTemplate.getForObject("http://test.test/13", Task.class)).thenReturn(atask);
        toDoTaskComponent.getTask(13);

    }

}