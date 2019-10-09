package ua.training.taxsystem.presentation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.training.taxsystem.util.properties.ViewProperties;

import static ua.training.taxsystem.util.properties.ViewProperties.PATH_INDEX;

@Controller
public class SignInController {
    @GetMapping("/")
    public String showForm() {
        System.out.println("I'm here");
        return ViewProperties.getViewPath(PATH_INDEX);
    }
}
