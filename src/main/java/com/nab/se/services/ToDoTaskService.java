package com.nab.se.services;

import com.nab.se.components.restful.ToDoTaskComponent;
import com.nab.se.domains.bigasusDomain.BigasusTask;
import com.nab.se.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.businessLogic.domainMapper.JsonPlaceHolderToBigasusMapper;
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