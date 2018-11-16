package com.nab.se.helloWorld.services;

import com.nab.se.helloWorld.components.domainMapper.JsonPlaceHolderToBigasusMapper;
import com.nab.se.helloWorld.components.externalClients.restful.ToDoTaskComponent;
import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void Should_DoSomething_When_SomethingHappen() throws Exception {
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