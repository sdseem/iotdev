package com.example.task345;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private final StorageService inMemoryStorageService;
    private final StorageService fileStorageService;

    public MainController(
            @Qualifier("inMemoryStorageService") StorageService inMemoryStorageService,
            @Qualifier("fileStorageService") StorageService fileStorageService) {
        this.inMemoryStorageService = inMemoryStorageService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/")
    public String page(Model model) {
        String saved = inMemoryStorageService.getJson();
        model.addAttribute("text", saved);
        return "page";
    }

    @PostMapping("/")
    public String saveText(Model model, @RequestParam("fname") String body) {
        try {
            String saved = inMemoryStorageService.saveAsObject(body);
            if (saved == null) {
                model.addAttribute("text", "");
            } else {
                model.addAttribute("text", saved);
            }
        } catch (Exception e) {
            model.addAttribute("message", "ERROR: INVALID JSON");
            model.addAttribute("text", inMemoryStorageService.getJson());
        }
        return "page";
    }

    @GetMapping("/file")
    public String pageFile(Model model) {
        model.addAttribute("text", fileStorageService.getJson());
        return "page_file";
    }

    @PostMapping("/file")
    public String saveTextInFile(Model model, @RequestParam("fname") String body) {
        try {
            String saved = fileStorageService.saveAsObject(body);
            model.addAttribute("text", saved);
        } catch (Exception e) {
            model.addAttribute("message", "ERROR: INVALID JSON");
            model.addAttribute("text", fileStorageService.getJson());
        }
        return "page_file";
    }
}
