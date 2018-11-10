package com.bigasus.newse.services;

import com.bigasus.newse.components.ToDoTaskComponent;
import com.bigasus.newse.domains.bigasusDomain.BigasusTask;
import com.bigasus.newse.domains.jsonPlaceHolderDomain.Task;
import com.bigasus.newse.logic.domainMapper.JsonPlaceHolderToBigasusMapper;
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
