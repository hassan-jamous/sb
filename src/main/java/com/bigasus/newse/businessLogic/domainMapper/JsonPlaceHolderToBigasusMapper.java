package com.bigasus.newse.businessLogic.domainMapper;


import com.bigasus.newse.domains.bigasusDomain.BigasusTask;
import com.bigasus.newse.domains.jsonPlaceHolderDomain.Task;
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
