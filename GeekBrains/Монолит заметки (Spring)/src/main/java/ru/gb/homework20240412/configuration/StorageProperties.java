package ru.gb.homework20240412.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Класс конфигурации.
 * Формирует адрес директории для хранения загруженных файлов
 */

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
