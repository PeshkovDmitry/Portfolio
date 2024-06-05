package ru.gb.resserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Сервер ресурсов
 * См. https://www.baeldung.com/spring-security-oauth-auth-server
 */

@SpringBootApplication
@ConfigurationPropertiesScan("ru.gb.resserver.configuration")
public class ResServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResServerApplication.class, args);
	}

}
