package ru.gb.homework20240412;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.gb.homework20240412.configuration.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Homework20240412Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework20240412Application.class, args);
	}

}
