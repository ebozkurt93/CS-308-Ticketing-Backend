package com.cs308.User;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User u) {
		userRepository.save(u);
	}
	
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUserByEmail(String email) {
		return userRepository.findByUserMail(email);
	}
	

}
