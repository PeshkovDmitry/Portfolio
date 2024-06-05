package ru.gb.homework20240412.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework20240412.domain.model.Task;
import ru.gb.homework20240412.domain.model.TaskStatus;
import ru.gb.homework20240412.service.TaskService;

import java.util.List;

/**
 * Контроллер для обработки Task через REST API
 */

@RestController
@AllArgsConstructor
@RequestMapping
public class TaskController {

    private final TaskService service;

    /**
     * Метод добавления задачи в хранилище
     * @param task
     * @return
     */

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.add(task);
    }

    /**
     * Метод для получения всех задач
     * @return
     */

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    /**
     * Метод для получения всех задач с указанным статусом
     * @param status
     * @return
     */

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getByStatus(status);
    }

    /**
     * Метод для обновления статуса задачи
     * @param id
     * @param task
     * @return
     */

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateStatus(id, task.getStatus());
    }

    /**
     * Метод для удаления задачи
     * @param id
     */

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.delete(id);
    }

}
