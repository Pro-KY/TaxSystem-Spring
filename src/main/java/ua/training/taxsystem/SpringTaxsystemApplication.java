package ua.training.taxsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ua.training.taxsystem.util.properties.ViewProperties;

@SpringBootApplication
public class SpringTaxsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaxsystemApplication.class, args);
	}

}
