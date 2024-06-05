package ru.gb.resserver.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.resserver.configuration.RemoteApiConfiguration;
import ru.gb.resserver.domain.Result;

import java.util.List;

/**
 * Сервис запроса ссылки на картинку из внешнего ресурса
 */

@Service
@AllArgsConstructor
public class CatsService {

    private final RestTemplate template;

    private final HttpHeaders headers;

    private final RemoteApiConfiguration remoteApiConfiguration;

    public Result[] get() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Result[]> entity = new HttpEntity<>(headers);
        ResponseEntity<Result[]> response = template.exchange(
                remoteApiConfiguration.getApi(),
                HttpMethod.GET,
                entity,
                Result[].class);
        return response.getBody();
    }
}
