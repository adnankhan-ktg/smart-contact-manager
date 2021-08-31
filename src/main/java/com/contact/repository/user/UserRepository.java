package com.contact.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.contact.models.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByMobileNumber(String mobileNumber);
	public User findByEmail(String email);
	public User findByMobileNumberOrEmail(String mobileNumber,String email);

}
