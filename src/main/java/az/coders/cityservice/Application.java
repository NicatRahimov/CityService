package az.coders.cityservice;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("az.coders.cityservice.model")
@EnableJpaRepositories("az.coders.cityservice.repositories")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
