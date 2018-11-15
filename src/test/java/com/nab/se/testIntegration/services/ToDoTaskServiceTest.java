package com.nab.se.testIntegration.services;

import com.nab.se.testIntegration.components.domainMapper.JsonPlaceHolderToBigasusMapper;
import com.nab.se.testIntegration.components.externalClients.restful.ToDoTaskComponent;
import com.nab.se.testIntegration.domains.nabDomain.NabTaskDomain;
import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ToDoTaskServiceTest {
    @Mock
    ToDoTaskComponent toDoTaskComponent;

    @Mock
    JsonPlaceHolderToBigasusMapper jsonPlaceHolderToBigasusMapper;

    @InjectMocks
    ToDoTaskService toDoTaskService;

    @Test
    public void getTask() throws Exception {
        Task exampleTask = new Task(3,3,"asdf", false);

        NabTaskDomain nabTaskDomainExample = new NabTaskDomain();
        nabTaskDomainExample.setTaskIdFromSource(3);
        Mockito.when(toDoTaskComponent.getTask(3)).thenReturn(exampleTask);
        Mockito.when(jsonPlaceHolderToBigasusMapper.mapJsonPlaceHolderTaskToBigasusTask(exampleTask)).thenReturn(nabTaskDomainExample);

        NabTaskDomain returned = this.toDoTaskService.getTask(3);
        Mockito.verify(toDoTaskComponent, Mockito.times(1)).getTask(3);
        Mockito.verify(jsonPlaceHolderToBigasusMapper, Mockito.times(1)).mapJsonPlaceHolderTaskToBigasusTask(exampleTask);
        assertEquals(3, returned.getTaskIdFromSource());
    }

}