package pl.edu.wszib.pos;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.thymeleaf.dialect.springdata.SpringDataDialect;


@PropertySources( {@PropertySource("classpath:db.properties"),@PropertySource("classpath:mail.properties") })
//@PropertySource("classpath:db.properties")
//@PropertySource("classpath:mail.properties")

@SpringBootApplication

public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}


}
