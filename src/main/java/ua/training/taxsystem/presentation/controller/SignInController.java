package ua.training.taxsystem.presentation.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.training.taxsystem.util.properties.ViewProperties;

import static ua.training.taxsystem.util.properties.ViewProperties.PATH_INDEX;
@Log4j2
@Controller
public class SignInController {
    @GetMapping("/")
    public String showForm() {
        log.info("I'm here");
        return ViewProperties.getViewPath(PATH_INDEX);
    }
}
