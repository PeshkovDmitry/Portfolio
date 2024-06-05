package ru.gb.homework20240412.domain.exception;

/**
 * Исключение, генерируемое при ошибке чтения файла из хранилища
 */

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
