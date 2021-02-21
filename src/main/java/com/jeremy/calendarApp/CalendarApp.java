package com.jeremy.calendarApp;

import com.jeremy.calendarApp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CalendarApp {

	public static void main(String[] args) {
		SpringApplication.run(CalendarApp.class, args);
	}

}
