package com.cs308;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.cs308.config.JwtFilter;

@SpringBootApplication
public class TicketreservationsystemApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/user/secure/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(TicketreservationsystemApplication.class, args);
	}
}
