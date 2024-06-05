package ru.gb.resserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.resserver.domain.Result;
import ru.gb.resserver.service.CatsService;

@RestController
@AllArgsConstructor
public class CatsController {

    private final CatsService catsService;

    @GetMapping("/cats")
    public Result[] getCats() {
        return catsService.get();
    }

}
