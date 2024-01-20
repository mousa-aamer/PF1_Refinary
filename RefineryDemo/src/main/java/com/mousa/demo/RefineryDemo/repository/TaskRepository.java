package com.mousa.demo.RefineryDemo.repository;

import com.mousa.demo.RefineryDemo.models.Task;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskRepository {

    private Map<Long, Task> tasks;
    private Long maxId;

    public TaskRepository() {
        tasks = new HashMap<>();
        //tasks.put(1L, new Task(1L, "Title X", "description X", Boolean.FALSE, new Date(), null));
        //tasks.put(2L, new Task(2L, "Title Y", "description Y", Boolean.TRUE, new Date(), new Date()));
        //maxId = 2L;
        maxId = 0L;
    }

    public List<Task> findAll() {
        return tasks.values().stream().toList();
    }

    public Optional<Task> findById(Long id) {
        Optional<Task> task = Optional.ofNullable(tasks.get(id));
        return task;
    }

    public Task save(Task task) {
        maxId++;
        task.setId(maxId);
        tasks.put(maxId, task);
        return task;
    }

    public Task update(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }
}
