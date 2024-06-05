package ru.gb.homework20240416.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.homework20240416.service.ServiceApi;

@Controller
@AllArgsConstructor
@RequestMapping("/about")
public class AboutController {

    private final ServiceApi serviceApi;

    @GetMapping
    public String getCharacterInfo(
            @RequestParam(defaultValue = "1") int id,
            @RequestParam(name="page", defaultValue = "1") int currentPage,
            Model model) {
        model.addAttribute("character", serviceApi.getCharacterInfo(id));
        model.addAttribute("currentPage", currentPage);
        return "about";
    }

}
