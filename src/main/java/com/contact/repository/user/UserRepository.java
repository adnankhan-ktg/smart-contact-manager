package com.contact.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.contact.models.user.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUsername(String b);

}
