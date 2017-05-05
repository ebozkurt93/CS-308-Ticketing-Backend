package com.cs308.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

	User findByMail(String email);
	

}
