package ru.gb.homework20240416.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.homework20240416.domain.Characters;
import ru.gb.homework20240416.service.ServiceApi;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final ServiceApi serviceApi;

    @GetMapping
    public String getCharacters(@RequestParam(defaultValue = "1") int page, Model model)
    {
        Characters allCharacters = serviceApi.getCharactersList(page);
        int pagesCount = allCharacters.getInfo().getPages();
        model.addAttribute("pages", allCharacters.getInfo().getPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("previousPage", page == 1 ? 1 : page - 1);
        model.addAttribute("nextPage", page == pagesCount ? pagesCount : page + 1);
        model.addAttribute("count", allCharacters.getInfo().getCount());
        model.addAttribute("characters", allCharacters.getResults());
        return "home";
    }
}
