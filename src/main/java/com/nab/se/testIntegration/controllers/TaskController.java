package com.nab.se.testIntegration.controllers;

import com.nab.se.testIntegration.domains.bigasusDomain.BigasusTask;
import com.nab.se.testIntegration.nonFunctional.aspects.annotations.LogMe;
import com.nab.se.testIntegration.services.ToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    ToDoTaskService toDoTaskService;

    @LogMe
    @GetMapping(value = "/todo/{taskId}")
    public ResponseEntity<BigasusTask> toDo(@PathVariable int taskId) {
        return new ResponseEntity<>(toDoTaskService.getTask(taskId), HttpStatus.OK);
    }
}
