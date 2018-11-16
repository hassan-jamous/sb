package com.nab.se.helloWorld.domains.nabDomain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NabTaskDomain {
    private int userResponsibleForTask;
    private int taskIdFromSource;
    private String commentFromSource;
}
