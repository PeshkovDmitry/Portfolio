package ru.gb.homework20240412.domain.exception;

/**
 * Исключение, генерируемое при несуществующей папке для хранения файлов,
 * или попытке сохранения пустого файла
 */

public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
