package com.nab.se.domains.bigasusDomain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BigasusTask {
    private int userResponsibleForTask;
    private int taskIdFromSource;
    private String commentFromSource;
}
