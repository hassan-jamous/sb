package com.bigasus.newse.services;

import com.bigasus.newse.components.ToDoTaskComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoTaskService {

    @Autowired
    ToDoTaskComponent toDoTaskComponent;

    public String getTask(int taskId) {
        return this.toDoTaskComponent.getTask(taskId).toString();
    }
}
