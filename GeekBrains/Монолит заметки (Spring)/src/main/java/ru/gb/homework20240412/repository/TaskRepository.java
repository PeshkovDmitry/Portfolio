package ru.gb.homework20240412.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.homework20240412.domain.model.Task;
import ru.gb.homework20240412.domain.model.TaskStatus;

import java.util.List;

/**
 * Репозиторий для хранения списка задач
 */

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>  {

    List<Task> findByStatus(TaskStatus status);

    @Transactional
    @Modifying
    @Query("update Task t set t.status = ?1 where t.id = ?2")
    void updateStatusById(TaskStatus status, Long id);

}
