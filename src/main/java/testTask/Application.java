package testTask;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("testTask")
public class Application {

	public static void main(String[] args) {
        // Create the Flyway instance
        Flyway flyway = new Flyway();

        // Point it to the database
        flyway.setDataSource("jdbc:mysql://localhost:3306/test", "admin", "admin");

        // Start the migration
        flyway.migrate();

		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
	}

}