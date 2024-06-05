package ru.gb.homework20240416;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.gb.homework20240416")
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

}
