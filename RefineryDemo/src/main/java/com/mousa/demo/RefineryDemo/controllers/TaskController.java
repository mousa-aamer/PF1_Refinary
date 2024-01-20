package com.mousa.demo.RefineryDemo.controllers;

import com.mousa.demo.RefineryDemo.models.Task;
import com.mousa.demo.RefineryDemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return service.loadTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        var task = service.loadTaskById(id);
        if(task == null) {
            throw new RuntimeException("No task found for ID " + id);
        }
        return task;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task newTask) {
        return service.createTask(newTask);
    }

    @PutMapping(path="/tasks/{id}", consumes={MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task task = service.updateTask(id, updatedTask);
        return ResponseEntity.ok(task);
    }

}
