package ua.testing.locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/api")
    public String getMainPage(){
        return "index.html";
    }
}