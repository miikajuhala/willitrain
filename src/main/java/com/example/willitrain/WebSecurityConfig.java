package com.example.willitrain;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.willitrain.web.AuthenticationFilter;
import com.example.willitrain.web.LoginFilter;

import  com.example.willitrain.web.UserDetailServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl userDetailsService; 
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable().cors().and().authorizeRequests()
      .antMatchers(HttpMethod.POST, "/login","/loginpage","/api/frames/*", "/api/**","/api/register/*, api/login").permitAll()
      .antMatchers(HttpMethod.GET ,"/api","/api/users/**","/getid/**","api/spots/**","/username", "/api/**","/role","/loginpage","/saveuser","/signup","/api/users/search/findByUsername","/api/users/search/findByUsername?admin").permitAll()
      .antMatchers(HttpMethod.PUT, "/api", "/api/**").permitAll()
     // .antMatchers(HttpMethod.GET, "api/spots", "api/users**").hasRole("admin")
     // .antMatchers(HttpMethod.POST, "/api/spots/add","/saveuser","/api/admin/newuser").authenticated()
      .antMatchers(HttpMethod.DELETE, "/api/spots/delete/*").permitAll()
          .anyRequest().authenticated()
          .and()
          // Filter for the api/login requests
          .addFilterBefore(new LoginFilter("/login",
           authenticationManager()),
                  UsernamePasswordAuthenticationFilter.class)
          // Filter for other requests to check JWT in header
          .addFilterBefore(new AuthenticationFilter(),
                  UsernamePasswordAuthenticationFilter.class);
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService)
	  .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = 
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000/", "https://exposnooker.herokuapp.com/"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*")); 
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();
        
        source.registerCorsConfiguration("/**", config);
        return source;
  }
	
}