package com.contact.services.user;

import com.contact.models.user.User;

public interface UserService {

	
	public User addUser(User user);
	public User updatePassword(User user);
	public User getUser(String str);

}
