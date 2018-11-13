package com.nab.se.businessLogic.domainMapper;


import com.nab.se.domains.bigasusDomain.BigasusTask;
import com.nab.se.domains.jsonPlaceHolderDomain.Task;
import org.springframework.stereotype.Component;

@Component
public class JsonPlaceHolderToBigasusMapper {

    public BigasusTask mapJsonPlaceHolderTaskToBigasusTask(Task jsonPlaceHolderTask) {
        BigasusTask bt = new BigasusTask();
        bt.setUserResponsibleForTask(jsonPlaceHolderTask.getUserId());
        bt.setTaskIdFromSource(jsonPlaceHolderTask.getId());
        bt.setCommentFromSource(jsonPlaceHolderTask.getTitle() + "...");
        return bt;
    }
}
