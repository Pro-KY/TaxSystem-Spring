package ua.training.taxsystem.util.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Component
@PropertySource("classpath:view.properties")
@Getter
@Setter
public class MessageProperties {
    private final String SIGNIN_ERROR = "SIGNIN_ERROR";
    private final String ERROR_PARSING = "PARSING_ERROR";
    private final String REPORT_DETAILS_ERROR = "REPORT_DETAILS_ERROR";
    private final String SERVICE_NULL_ENTITY_ERROR = "SERVICE_NULL_ENTITY_ERROR";
    private final String SERVICE_TRANSACTION_ERROR = "SERVICE_TRANSACTION_ERROR";
}
