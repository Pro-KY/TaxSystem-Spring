package ua.training.taxsystem.presentation.controller;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.service.SignInService;
import ua.training.taxsystem.util.constans.Attributes;
import ua.training.taxsystem.util.constans.StateApprovalEnum;
import ua.training.taxsystem.util.constans.UserTypes;
import ua.training.taxsystem.util.properties.MessageProperties;
import ua.training.taxsystem.util.properties.ViewProperties;

import java.util.Optional;

import static ua.training.taxsystem.util.properties.ViewProperties.PATH_INDEX;

@Log4j2
@Controller
@AllArgsConstructor
@SessionAttributes({"user, isUserAuthorized"})
public class SignInController {
    private final SignInService signInService;

    @GetMapping("/")
    public String showSignInPage() {
        return ViewProperties.getViewPath(PATH_INDEX);
    }

    @PostMapping("/signIn")
    public String signIn(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         Model model) {
        Optional<User> optionalUser = signInService.getAuthorizedUser(email, password);
        boolean isUserAuthorized = optionalUser.isPresent();

        model.addAttribute(Attributes.IS_USER_AUTHORIZED, isUserAuthorized);

            if (isUserAuthorized) {
                final User user = optionalUser.get();
                final String type = user.getUserType().getType();

                boolean isInspector = type.equals(UserTypes.INSPECTOR.getType());

                if (isInspector) {
                    final PaginationDto currentPaginationDto = CommandUtil.getInstance().getCurrentPaginationDto(session);
                    final StateApproval stateApproval = new StateApproval(StateApprovalEnum.PROCESSING.getStateId());
                    final PaginationDto updatedPaginationDto = reportApprovalService.getUntreatedReports(currentPaginationDto, stateApproval, user);
                    session.setAttribute(Attributes.REPORTS_APPROVAL_TYPE, stateApproval.getId());
                    session.setAttribute(Attributes.PAGINATION_INFO, updatedPaginationDto);
                }

                String fragmentPath = isInspector ? FRAGMENT_PATH_SENT_REPORTS : FRAGMENT_PATH_SEND_REPORT;
                request.setAttribute(Attributes.FRAGMENT_PATH, ViewProperties.getViewPath(fragmentPath));
            } else {
                request.setAttribute(Attributes.ALERT_ERROR, true);
                request.setAttribute(Attributes.ALERT_MSG, MessageProperties.getMessage(SIGNIN_ERROR));
            }
        }


        return null;
    }
}
