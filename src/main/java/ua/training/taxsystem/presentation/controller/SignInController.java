package ua.training.taxsystem.presentation.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.training.taxsystem.dto.PaginationDto;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.service.ReportApprovalService;
import ua.training.taxsystem.service.SignInService;
import ua.training.taxsystem.util.constans.Attributes;
import ua.training.taxsystem.util.constans.StateApprovalEnum;
import ua.training.taxsystem.util.constans.UserTypes;
import ua.training.taxsystem.util.properties.MessageProperties;
import ua.training.taxsystem.util.properties.ViewProperties;

import java.util.Optional;


@Log4j2
@Controller
@AllArgsConstructor
@SessionAttributes({"user", "isUserAuthorized", "paginationInfo", "approvalStateId"})
public class SignInController {
    private final SignInService signInService;
    private final ReportApprovalService reportApprovalService;
    ViewProperties viewProperties;
    MessageProperties messageProperties;


    @GetMapping("/")
    public String showSignInPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return viewProperties.getPATH_INDEX();
    }


    @PostMapping("/sendReport")
    public ModelAndView sendReport(@SessionAttribute(required = false) User user) {
        log.info("in session" + user.toString());

        return null;
    }

    @PostMapping("/signIn")
    public ModelAndView signIn(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @SessionAttribute(required = false) PaginationDto paginationInfo) { // Model model
        Optional<User> optionalUser = signInService.getAuthorizedUser(email, password);
        boolean isUserAuthorized = optionalUser.isPresent();
        final ModelAndView modelAndView = new ModelAndView();

        String pagePath = isUserAuthorized ? viewProperties.getPATH_MAIN() : viewProperties.getPATH_INDEX();
        modelAndView.addObject(Attributes.IS_USER_AUTHORIZED, isUserAuthorized);

        if (isUserAuthorized) {
            final User user = optionalUser.get();
            log.info(user.toString());
            final String type = user.getUserType().getType();
            modelAndView.addObject(Attributes.USER, user);
            boolean isInspector = type.equals(UserTypes.INSPECTOR.getType());
            log.info(isInspector);

            if (isInspector) {
                final PaginationDto currentPaginationDto = paginationInfo != null ? paginationInfo : new PaginationDto();
                final StateApproval stateApproval = new StateApproval(StateApprovalEnum.PROCESSING.getStateId());
                final PaginationDto updatedPaginationDto = reportApprovalService.getUntreatedReports(currentPaginationDto, stateApproval, user);
                modelAndView.addObject(Attributes.REPORTS_APPROVAL_TYPE, stateApproval.getId());
                modelAndView.addObject(Attributes.PAGINATION_INFO, updatedPaginationDto);
            }


            String fragmentPath = isInspector ? viewProperties.getFRAGMENT_PATH_SENT_REPORTS() : viewProperties.getFRAGMENT_PATH_SEND_REPORT();
            modelAndView.addObject(Attributes.FRAGMENT_PATH, fragmentPath);
        } else {
            modelAndView.addObject(Attributes.ALERT_ERROR, true);
            modelAndView.addObject(Attributes.ALERT_MSG, true);
            modelAndView.addObject(Attributes.ALERT_MSG, messageProperties.getSIGNIN_ERROR());
        }
        modelAndView.setViewName(pagePath);

        return modelAndView;
    }
}
