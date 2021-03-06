package com.nab.se.helloWorld.controllers;

import com.nab.se.helloWorld.components.requestValidators.TaskRequestValidation;
import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.nonFunctional.aspects.annotations.LogMe;
import com.nab.se.helloWorld.services.ToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    TaskRequestValidation taskRequestValidation;

    @Autowired
    ToDoTaskService toDoTaskService;

    @LogMe
    @GetMapping(value = "/todo/{taskId}")
    public ResponseEntity<NabTaskDomain> toDo(@PathVariable int taskId) {
        this.taskRequestValidation.verifyToDoTaskRequest(taskId);
        return new ResponseEntity<>(toDoTaskService.getTask(taskId), HttpStatus.OK);
    }
}
