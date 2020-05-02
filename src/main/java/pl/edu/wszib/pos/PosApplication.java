package pl.edu.wszib.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.thymeleaf.dialect.springdata.SpringDataDialect;


@PropertySource("classpath:db.properties")
@PropertySource("classpath:mail.properties")
@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}
}
