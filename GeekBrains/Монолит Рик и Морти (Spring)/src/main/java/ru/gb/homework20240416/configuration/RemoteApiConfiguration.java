package ru.gb.homework20240416.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "character")
@Getter
@Setter
public class RemoteApiConfiguration {

    private String api;

}
