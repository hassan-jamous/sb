package com.nab.se.helloWorld.components.requestValidators;

import com.nab.se.helloWorld.nonFunctional.exceptions.ValidationException;
import com.nab.se.helloWorld.util.StringVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestValidation {
    @Autowired
    StringVerification stringVerification;

    public void verifyToDoTaskRequest(int taskId){
        if (taskId < 0) {
            throw new ValidationException();
        }
    }
}
