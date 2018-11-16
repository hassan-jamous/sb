package com.nab.se.helloWorld.components.domainMapper;


import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
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
