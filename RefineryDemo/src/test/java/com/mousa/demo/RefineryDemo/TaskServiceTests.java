package com.mousa.demo.RefineryDemo;

import com.mousa.demo.RefineryDemo.models.Task;
import com.mousa.demo.RefineryDemo.repository.TaskRepository;
import com.mousa.demo.RefineryDemo.services.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTests {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void test_loadTasks_notEmpty() {
        Task task = Mockito.mock(Task.class);
        List<Task> tasks = new LinkedList<>();
        tasks.add(task);
        Mockito.when(repository.findAll()).thenReturn(tasks);

        List<Task> loadedTasks = service.loadTasks();

        Assertions.assertEquals(tasks.size(), loadedTasks.size());
    }
}
