package com.example.willitrain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.willitrain.web.User;
import com.example.willitrain.web.UserRepository;
import com.example.willitrain.web.UserRoute;
import com.example.willitrain.web.UserRouteRepository;


@SpringBootApplication
public class WillitrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(WillitrainApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository uRepository, UserRouteRepository rRepository) {
		return (args) -> {
			
			User user = new User();
			user.setUsername("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole("admin");
			uRepository.save(user);
			
			UserRoute uroute = new UserRoute();
			uroute.setRoutename("first route");
			uroute.setEnd("Kirkkonummi");
			uroute.setStart("Espoo");
			uroute.setUser(user);
			rRepository.save(uroute);
			
			};
		}
	
	
}