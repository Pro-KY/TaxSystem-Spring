package ua.training.taxsystem.config;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.*;
import ua.training.taxsystem.util.PaginationHandler;

@Configuration
@PropertySources({
        @PropertySource("classpath:view.properties"),
        @PropertySource("classpath:message.properties")
})
public class ApplicationConfig {

    @Scope("prototype")
    @Bean
    public PaginationHandler paginationHandler() {
        return new PaginationHandler();
    }
}