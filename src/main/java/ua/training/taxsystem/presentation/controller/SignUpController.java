package ua.training.taxsystem.presentation.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.training.taxsystem.util.constans.Attributes;
import ua.training.taxsystem.util.properties.ViewProperties;


@Log4j2
@Controller
@AllArgsConstructor
@SessionAttributes(Attributes.IS_SIGN_UP)
public class SignUpController {
    ViewProperties viewProperties;

    @GetMapping("/getSignUpFragment")
    public ModelAndView showSignUpPage() {
        log.info("getSignUpFragment called");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(Attributes.IS_SIGN_UP, true);
        modelAndView.setViewName(viewProperties.getPATH_INDEX());
        return modelAndView;
    }

}
