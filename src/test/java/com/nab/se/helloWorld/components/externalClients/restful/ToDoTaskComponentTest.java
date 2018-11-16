package com.nab.se.helloWorld.components.externalClients.restful;

import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.helloWorld.nonFunctional.exceptions.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ToDoTaskComponentTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    ToDoTaskComponent toDoTaskComponent;

    @Test
    public void Should_ReturnTaskObject_When_SomethingHappens() throws Exception {
        ReflectionTestUtils.setField(toDoTaskComponent, "jsonPlaceHolderEndpoint", "http://test.test/");
        Task atask = new Task(3,4, "title", false);
        Mockito.when(restTemplate.getForObject("http://test.test/13", Task.class)).thenReturn(atask);

        Task task = toDoTaskComponent.getTask(13);

        Mockito.verify(restTemplate, Mockito.times(1)).getForObject("http://test.test/13", Task.class);
        assertEquals(atask.getUserId(), task.getUserId());
    }

    @Test(expected = ValidationException.class)
    public void Should_ThrowValidationException_When_ReturnedValueIsWrong() throws Exception {
        ReflectionTestUtils.setField(toDoTaskComponent, "jsonPlaceHolderEndpoint", "http://test1.test/");
        Task atask = new Task(3,4, "", false);
        Mockito.when(restTemplate.getForObject("http://test1.test/13", Task.class)).thenReturn(atask);

        toDoTaskComponent.getTask(13);
    }

}