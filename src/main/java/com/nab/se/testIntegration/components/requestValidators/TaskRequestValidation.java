package com.nab.se.testIntegration.components.requestValidators;

import com.nab.se.testIntegration.nonFunctional.exceptions.ValidationException;
import com.nab.se.testIntegration.util.StringVerification;
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
