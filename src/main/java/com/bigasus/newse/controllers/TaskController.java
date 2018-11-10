package com.bigasus.newse.controllers;

import com.bigasus.newse.domains.bigasusDomain.BigasusTask;
import com.bigasus.newse.services.ToDoTaskService;
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

    @GetMapping(value = "/todo/{taskId}")
    public ResponseEntity<BigasusTask> coordinates(@PathVariable int taskId) {
        return new ResponseEntity<>(toDoTaskService.getTask(taskId), HttpStatus.OK);
    }
}
