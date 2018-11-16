package com.nab.se.helloWorld.test.stubbed;

import com.nab.se.helloWorld.domains.jsonPlaceHolderDomain.Task;
import com.nab.se.helloWorld.domains.nabDomain.NabTaskDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldStubbedTest {
    @MockBean
    private RestTemplate restTemplateMock;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void Should_DoSomething_When_SomethingHappen() {
        Task exampleTask = new Task(3,3,"asdf", false);
        Mockito.when(restTemplateMock.getForObject("https://jsonplaceholder.typicode.com/todos/3", Task.class)).thenReturn(exampleTask);

        NabTaskDomain body = this.testRestTemplate.getForObject("/todo/3", NabTaskDomain.class);

        assertEquals("asdf...", body.getCommentFromSource());
    }

}
