package com.contact.services.user.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.contact.models.user.User;
import com.contact.repository.user.UserRepository;
import com.contact.services.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bc;
	


	@Override
	public User addUser(User user) {
		User tempUser = null;
		user.setOtp(null);
		user.setId(UUID.randomUUID().toString());
		
		try {
			user.setPassword(this.bc.encode(user.getPassword()));
			tempUser = this.userRepository.save(user);
			return tempUser;
		}catch (Exception e) {
			e.printStackTrace();
			return tempUser;
		}
	}


	@Override
	public User updatePassword(User user) {
		User tempUser = null;
		try {
			tempUser = this.userRepository.save(user);
			return tempUser;
		}catch (Exception e) {
		e.printStackTrace();
		return tempUser;
		}
	}


	@Override
	public User getUser(String str) {
		User tempUser = null;
		if(StringUtils.isNumeric(str))
		{
			try {
             tempUser = this.userRepository.findByMobileNumber(str);
             return tempUser;
                 
			}catch (Exception e) {
				e.printStackTrace();
				return tempUser;
			}
                			
		}else {
			try {
                tempUser = this.userRepository.findByEmail(str);
                return tempUser;
			}catch (Exception e) {
				e.printStackTrace();
				return tempUser;
			}
		}
	}

}
