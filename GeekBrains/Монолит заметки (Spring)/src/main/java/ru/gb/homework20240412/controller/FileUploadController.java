package ru.gb.homework20240412.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.gb.homework20240412.domain.exception.StorageFileNotFoundException;
import ru.gb.homework20240412.interfaces.StorageService;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Контроллер, обрабатывающий загрузку файлов на сервер и выгрузку их из сервера
 */

@Controller
@RequestMapping("/upload")
@AllArgsConstructor
public class FileUploadController {

    private final StorageService storageService;


    /**
     * Метод для выдачи страницы, сгенерированной шаблоном Thymeleaf,
     * и содержащей список загруженных файлов и форму для загрузки нового файла
     * @param model
     * @return
     * @throws IOException
     */

    @GetMapping
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute(
                "files",
                storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder
                                .fromMethodName(
                                        FileUploadController.class,
                                        "serveFile",
                                        path.getFileName().toString())
                                .build()
                                .toUri()
                                .toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    /**
     * Метод для получения файла из хранилища
     * Файл передается в теле ответа
     * @param filename
     * @return
     */

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    /**
     * Метод для загрузки в хранилище файла, получаемого от фронтенда
     * @param file
     * @param redirectAttributes
     * @return
     */

    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "Вы успешно загрузили файл " + file.getOriginalFilename() + "!");

        return "redirect:/upload";
    }

    /**
     * Метод, перехватывающий исключение, генерируемое при отсутствии запрашиваемого файла
     * @param exc
     * @return
     */

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
