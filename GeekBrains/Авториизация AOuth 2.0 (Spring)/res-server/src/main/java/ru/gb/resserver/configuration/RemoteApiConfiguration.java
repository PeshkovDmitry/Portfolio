package ru.gb.resserver.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Конфигурация адреса внешнего API
 */

@ConfigurationProperties(prefix = "cats")
@Getter
@Setter
public class RemoteApiConfiguration {

    private String api;

}
