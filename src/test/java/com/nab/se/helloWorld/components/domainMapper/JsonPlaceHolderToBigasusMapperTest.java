package com.nab.se.helloWorld.components.domainMapper;

import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonPlaceHolderToBigasusMapperTest {

    JsonPlaceHolderToBigasusMapper jsonPlaceHolderToBigasusMapperUnderTest = new JsonPlaceHolderToBigasusMapper();

    @Test
    public void Should_Map_Between_Two_Domains() throws Exception {
        Task jsonPlaceHolderTask = new Task(1,3,"asdf", false);

        NabTaskDomain returnedValue = jsonPlaceHolderToBigasusMapperUnderTest.mapJsonPlaceHolderTaskToBigasusTask(jsonPlaceHolderTask);

        assertEquals(3, returnedValue.getTaskIdFromSource());
    }

}