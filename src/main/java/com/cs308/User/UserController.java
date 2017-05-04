package com.cs308.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs308.config.key.KeyFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "Hi";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public void registerUser(@RequestBody User u) {
		userService.addUser(u);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getallusers")
	public ArrayList<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestBody User login) throws ServletException {

		String jwtToken = "";
		if (login.getUserMail() == null || login.getUserPass() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getUserMail();
		String password = login.getUserPass();

		User user = userService.getUserByEmail(email);

		if (user == null) {
			throw new ServletException("User email not found.");
		}

		String pwd = user.getUserPass();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your email and password.");
		}

		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		// 6 hours
		Date endDate = new Date(t + (6 * 60 * 60000));
		jwtToken = Jwts.builder().setSubject(email)/*.claim("roles", user.getRoles())*/.setIssuedAt(new Date())
				.setExpiration(endDate).signWith(SignatureAlgorithm.HS256, KeyFactory.jwtKey).compact();

		return jwtToken;
	}

}
