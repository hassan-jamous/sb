package com.nab.se.testIntegration.services;

import com.nab.se.testIntegration.components.externalClients.restful.ToDoTaskComponent;
import com.nab.se.testIntegration.domains.bigasusDomain.BigasusTask;
import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.testIntegration.components.domainMapper.JsonPlaceHolderToBigasusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoTaskService {
    @Autowired
    ToDoTaskComponent toDoTaskComponent;

    @Autowired
    JsonPlaceHolderToBigasusMapper jsonPlaceHolderToBigasusMapper;

    public BigasusTask getTask(int taskId) {
        Task jsonPlaceHolderTask = this.toDoTaskComponent.getTask(taskId);
        return jsonPlaceHolderToBigasusMapper.mapJsonPlaceHolderTaskToBigasusTask(jsonPlaceHolderTask);
    }
}
