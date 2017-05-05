package com.cs308.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs308.config.JwtMyHelper;
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
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(Role.USER);
		u.setRoles(roles);
		userService.addUser(u);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/secure/getallusers")
	public ArrayList<User> getAllUsers(@RequestHeader(value = "Authorization") String jwt) throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			return userService.getAllUsers();
		} else
			throw new ServletException("You are not authorized to do that");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/secure/addadminbyemail")
	public void addAdminByEmail(@RequestBody User u, @RequestHeader(value = "Authorization") String jwt)
			throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			String email = u.getMail();
			User user = userService.getUserByEmail(email);
			Collection<Role> roles = user.getRoles();
			roles.add(Role.ADMIN);
			roles.remove(Role.USER);
			user.setRoles(roles);
			userService.addUser(user);
		} else
			new ServletException("You are not authorized to do that");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/secure/removeadminbyemail")
	public void removeAdminByEmail(@RequestBody User u, @RequestHeader(value = "Authorization") String jwt)
			throws ServletException {
		if (JwtMyHelper.getIfJWTAdmin(jwt)) {
			String email = u.getMail();
			if (!(JwtMyHelper.getJwtEmail(jwt).equals(email))) {
				User user = userService.getUserByEmail(email);
				Collection<Role> roles = user.getRoles();
				roles.add(Role.USER);
				roles.remove(Role.ADMIN);
				user.setRoles(roles);
				userService.addUser(user);
			} else throw new ServletException("Geri bas");

		} else
			new ServletException("You are not authorized to do that");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@RequestBody User login) throws ServletException {

		String jwtToken = "";
		if (login.getMail() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = login.getMail();
		String password = login.getPassword();

		User user = userService.getUserByEmail(email);

		if (user == null) {
			throw new ServletException("User email not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your email and password.");
		}

		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		// 6 hours
		Date endDate = new Date(t + (6 * 60 * 60000));
		jwtToken = Jwts.builder().setSubject(email).claim("roles", user.getRoles()).setIssuedAt(new Date())
				.setExpiration(endDate).signWith(SignatureAlgorithm.HS256, KeyFactory.jwtKey).compact();

		return jwtToken;
	}

}
