package ru.gb.homework20240416.service;

import lombok.AllArgsConstructor;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.gb.homework20240416.configuration.RemoteApiConfiguration;
import ru.gb.homework20240416.domain.Characters;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.homework20240416.domain.Result;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi{

    private final RestTemplate template;

    private final HttpHeaders headers;

    private final RemoteApiConfiguration remoteApiConfiguration;

    @Override
    public Characters getCharactersList(int page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(remoteApiConfiguration.getApi())
                .queryParam("page",page)
                .build();
        ResponseEntity<Characters> response = template.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Characters.class);
        return response.getBody();
    }

    @Override
    public Result getCharacterInfo(int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                remoteApiConfiguration.getApi() + "/" + id,
                HttpMethod.GET,
                entity,
                Result.class);
        return response.getBody();
    }
}
