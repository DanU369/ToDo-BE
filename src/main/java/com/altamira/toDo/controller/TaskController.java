package com.altamira.toDo.controller;

import com.altamira.toDo.model.Task;
import com.altamira.toDo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }

    @PostMapping("/finish")
    public void finishTask(@RequestBody Task details) {
        System.out.println("here" + details);
        taskService.finishTask(details.getFinishedOn(), details.getActualWorkTime(), details.getId());
    }


}


