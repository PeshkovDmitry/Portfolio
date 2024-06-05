package ru.gb.homework20240412.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework20240412.domain.model.Task;
import ru.gb.homework20240412.domain.model.TaskStatus;
import ru.gb.homework20240412.repository.TaskRepository;

import java.util.List;

/**
 * Сервис, реализующий взаимодействие между контроллером задач и репозиторием
 */

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    /**
     * Метод добавления задачи в репозиторий
     * @param task
     * @return
     */

    public Task add(Task task) {
        return repository.save(task);
    }

    /**
     * Метод получения всех задач из репозитория
     * @return
     */

    public List<Task> getAll() {
        return repository.findAll();
    }


    /**
     * Метод для получения задач с указанным статусом
     * @param status
     * @return
     */

    public List<Task> getByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /**
     * Метод для обновления статуса задачи
     * @param id
     * @param status
     */

    public Task updateStatus(Long id, TaskStatus status) {
        repository.updateStatusById(status, id);
        return repository.findById(id).get();
    }

    /**
     * Метод для удаления задачи из репозитория
     * @param id
     * @return
     */

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
