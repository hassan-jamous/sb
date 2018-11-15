package com.nab.se.testIntegration.components.domainMapper;

import com.nab.se.testIntegration.domains.nabDomain.NabTaskDomain;
import com.nab.se.testIntegration.domains.jsonPlaceHolderDomain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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