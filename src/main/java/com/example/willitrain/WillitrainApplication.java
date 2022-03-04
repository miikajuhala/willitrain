package com.example.willitrain;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.willitrain.web.Frame;
import com.example.willitrain.web.FrameRepository;
import com.example.willitrain.web.User;
import com.example.willitrain.web.UserRepository;



@SpringBootApplication
public class WillitrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(WillitrainApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository uRepository, FrameRepository fRepository) {
		return (args) -> {
			
			User user = new User();
			user.setUsername("miika");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setRole("admin");
			
			
			Frame frame = new Frame();
			frame.setName("first game");
			frame.setPlayer1("miika");
			frame.setPlayer2("janne");
			frame.setPlayer1Score(147);
			frame.setPlayer2Score(23);
			frame.setReds(13);
			frame.setBlack(true);  
			frame.setPink(false);  
			frame.setBlue(false);  
			frame.setGreen(true);  
			frame.setBrown(false);  
			frame.setYellow(true);  
			fRepository.save(frame);
			
			
			uRepository.save(user);
			
			
			
			
			
			
			};
		}
	
	
}