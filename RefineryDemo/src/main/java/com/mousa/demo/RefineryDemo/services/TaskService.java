package com.mousa.demo.RefineryDemo.services;

import com.mousa.demo.RefineryDemo.models.Task;
import com.mousa.demo.RefineryDemo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> loadTasks() {
        return repository.findAll();
    }

    public Task loadTaskById(Long id) {
        Optional<Task> task = repository.findById(id);
        return task.orElse(null);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task oldTask = repository.findById(id).orElseThrow(() -> new RuntimeException("No task found for ID: " + id));
        oldTask.setTitle(updatedTask.getTitle());
        oldTask.setDescription(updatedTask.getDescription());
        oldTask.setCompleted(updatedTask.getCompleted());
        oldTask.setCreatedDate(updatedTask.getCreatedDate());
        oldTask.setCompletedDate(updatedTask.getCompletedDate());
        updatedTask = repository.update(oldTask);
        return updatedTask;
    }
}
