package com.nab.se.testIntegration.components.domainMapper;


import com.nab.se.testIntegration.domains.nabDomain.NabTaskDomain;
import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import org.springframework.stereotype.Component;

@Component
public class JsonPlaceHolderToBigasusMapper {

    public NabTaskDomain mapJsonPlaceHolderTaskToBigasusTask(Task jsonPlaceHolderTask) {
        NabTaskDomain bt = new NabTaskDomain();
        bt.setUserResponsibleForTask(jsonPlaceHolderTask.getUserId());
        bt.setTaskIdFromSource(jsonPlaceHolderTask.getId());
        bt.setCommentFromSource(jsonPlaceHolderTask.getTitle() + "...");
        return bt;
    }
}
