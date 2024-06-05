package ru.gb.homework20240412.domain.model;

/**
 * Энумиратор статусов задачи
 */

public enum TaskStatus {

    /**
     * Задача не взята в работу
     */

    NOT_STARTED,

    /**
     * Задача в процессе выполнения
     */

    IN_PROGRESS,

    /**
     * Задача выполнена
     */

    COMPLETED;

}
