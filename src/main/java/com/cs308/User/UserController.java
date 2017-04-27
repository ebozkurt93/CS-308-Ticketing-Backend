package com.cs308.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "Working";

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public void registerUser(@RequestBody User u) {
		userService.addUser(u);
	}
	
}
