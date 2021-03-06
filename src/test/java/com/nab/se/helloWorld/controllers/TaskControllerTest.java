package com.nab.se.helloWorld.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.se.helloWorld.components.requestValidators.TaskRequestValidation;
import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.services.ToDoTaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @Mock
    TaskRequestValidation taskRequestValidation;

    @Mock
    ToDoTaskService toDoTaskService;

    @InjectMocks
    TaskController taskController;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(taskController)
                .build();
    }

    @Test
    public void Should_DoSomething_When_Something() throws Throwable {
        NabTaskDomain nabTaskDomainExample = new NabTaskDomain();
        nabTaskDomainExample.setTaskIdFromSource(3);
        Mockito.when(toDoTaskService.getTask(3)).thenReturn(nabTaskDomainExample);
        Mockito.doNothing().when(taskRequestValidation).verifyToDoTaskRequest(3);

        MockHttpServletResponse response = mvc.perform(
                get("/todo/3").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        NabTaskDomain taskResponse = new ObjectMapper().readValue(response.getContentAsString(), NabTaskDomain.class);

        Mockito.verify(toDoTaskService, Mockito.times(1)).getTask(3);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(3, taskResponse.getTaskIdFromSource());
    }
}