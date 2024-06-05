package ru.gb.homework20240412.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Интерфейс, декларирующий функционал сервиса для обработки файлов
 */

public interface StorageService {

    /**
     * Метод инициализации хранилища
     */

    void init();

    /**
     * Метод для сохранения файла в хранилище
     * @param file
     */

    void store(MultipartFile file);

    /**
     * Метод для получения путей ко всем файлам хранилища
     * @return
     */

    Stream<Path> loadAll();

    /**
     * Метод для получения пути к указанному файлу
     * @param filename
     * @return
     */

    Path load(String filename);

    /**
     * Метод для считывания содержимого файла из хранилища
     * @param filename
     * @return
     */

    Resource loadAsResource(String filename);

    /**
     * Метод для удаления всех файлов в хранилище
     */

    void deleteAll();

}
