package com.nab.se.testIntegration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.se.testIntegration.domains.nabDomain.NabTaskDomain;
import com.nab.se.testIntegration.nonFunctional.aspects.LoggingAspect;
import com.nab.se.testIntegration.services.ToDoTaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest {

    @MockBean
    ToDoTaskService toDoTaskService;

    @SpyBean
    LoggingAspect loggingAspect;

    @Autowired
    TaskController taskController;

    @Autowired
    private ObjectMapper jsonObjectMapper;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(taskController)
                .build();
    }

    @Test
    public void test() throws Throwable {
        NabTaskDomain nabTaskDomainExample = new NabTaskDomain();
        nabTaskDomainExample.setTaskIdFromSource(3);

        Mockito.when(toDoTaskService.getTask(3)).thenReturn(nabTaskDomainExample);

        MockHttpServletResponse response = mvc.perform(
                get("/todo/3").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Mockito.verify(toDoTaskService, Mockito.times(1)).getTask(3);
        Mockito.verify(loggingAspect, Mockito.times(1)).around(Mockito.any());
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        NabTaskDomain taskResponse = jsonObjectMapper.readValue(response.getContentAsString(), NabTaskDomain.class);
        assertEquals(3, taskResponse.getTaskIdFromSource());

    }
}