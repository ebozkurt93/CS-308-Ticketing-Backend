package com.cs308;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.cs308.config.JwtFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TicketreservationsystemApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/user/secure/*");
		registrationBean.addUrlPatterns("/ticket/secure/*");
		registrationBean.addUrlPatterns("/category/secure/*");
		registrationBean.addUrlPatterns("/event/secure/*");
		return registrationBean;
	}
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/user/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/user/secure/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/event/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/event/secure/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/ticket/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/ticket/secure/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/category/*").allowedOrigins("http://localhost:9000");
				registry.addMapping("/category/secure/*").allowedOrigins("http://localhost:9000");


			}
		};
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(TicketreservationsystemApplication.class, args);
	}
}
