package com.nab.se.helloWorld.services;

import com.nab.se.helloWorld.components.externalClients.restful.ToDoTaskComponent;
import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.helloWorld.components.domainMapper.JsonPlaceHolderToBigasusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoTaskService {
    @Autowired
    ToDoTaskComponent toDoTaskComponent;

    @Autowired
    JsonPlaceHolderToBigasusMapper jsonPlaceHolderToBigasusMapper;

    public NabTaskDomain getTask(int taskId) {
        Task jsonPlaceHolderTask = this.toDoTaskComponent.getTask(taskId);
        return jsonPlaceHolderToBigasusMapper.mapJsonPlaceHolderTaskToBigasusTask(jsonPlaceHolderTask);
    }
}
