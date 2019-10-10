package ua.training.taxsystem.util.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Component
@PropertySource("classpath:view.properties")
@Getter
@Setter
public class ViewProperties {
    @Value("${PATH_INDEX}")
    private String PATH_INDEX = "PATH_INDEX";

    @Value("${PATH_MAIN}")
    private String PATH_MAIN = "PATH_MAIN";

    @Value("${FRAGMENT_PATH_SEND_REPORT}")
    private String FRAGMENT_PATH_SEND_REPORT = "FRAGMENT_PATH_SEND_REPORT";
    @Value("${FRAGMENT_PATH_SENT_REPORTS}")
    private String FRAGMENT_PATH_SENT_REPORTS = "FRAGMENT_PATH_SENT_REPORTS";

    public static final String PATH_ERROR = "PATH_ERROR";
    public static final String FRAGMENT_PATH_SIGN_IN = "FRAGMENT_PATH_SIGN_IN";
    public static final String FRAGMENT_PATH_PROCESS_REPORT = "FRAGMENT_PATH_PROCESS_REPORT";
    public static final String FRAGMENT_PATH_SIGN_UP = "FRAGMENT_PATH_SIGN_UP";
    public static final String FRAGMENT_PATH_EDIT_REPORT = "FRAGMENT_PATH_EDIT_REPORT";
    public static final String FRAGMENT_PATH_APPROVING = "FRAGMENT_PATH_APPROVING";
    public static final String FRAGMENT_PATH_REPORT_DETAILS = "FRAGMENT_PATH_REPORT_DETAILS";

}
