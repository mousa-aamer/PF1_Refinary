package com.mousa.demo.RefineryDemo;

import com.mousa.demo.RefineryDemo.controllers.TaskController;
import com.mousa.demo.RefineryDemo.models.Task;
import com.mousa.demo.RefineryDemo.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTests {

    @MockBean
    private TaskService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_loadTasks_notEmpty() throws Exception {
        List<Task> tasks = List.of(Task.builder().title("SPring Boot Task").build());
        Mockito.when(service.loadTasks()).thenReturn(tasks);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").isNotEmpty());
    }
}
