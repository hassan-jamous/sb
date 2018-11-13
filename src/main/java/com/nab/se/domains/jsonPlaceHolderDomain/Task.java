package com.nab.se.domains.jsonPlaceHolderDomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    int userId;
    int id;
    String title;
    boolean completed;
}