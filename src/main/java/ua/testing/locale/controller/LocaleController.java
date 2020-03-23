package ua.testing.locale.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.testing.locale.dto.UsersDTO;
import ua.testing.locale.service.LocaleService;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LocaleController {
    @Autowired
    private final LocaleService localeService;

    public LocaleController(LocaleService localeService) {
        this.localeService = localeService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "eng")
    public UsersDTO localeEngController(){
        localeService.setLocale(new Locale("eng"));
        localeService.print();
        return  localeService.getAllUsers();
    }

    @PostMapping(value = "ukr")
    public UsersDTO LocaleUkrController(){
        localeService.setLocale(new Locale("ua", "UA"));
        localeService.print();
        return  localeService.getAllUsers();
    }
}

