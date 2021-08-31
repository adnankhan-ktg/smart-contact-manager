package com.contact.services.temp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contact.models.user.User;
import com.contact.repository.user.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
 @Autowired
 private UserRepository userRepostitory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
		User user = new User();
		    if(StringUtils.isNumeric(username))
		    {
		    	user = this.userRepostitory.findByMobileNumber(username);
		    }else {
		    	user = this.userRepostitory.findByEmail(username);
		    }

             if(user == null)
             {
            	 throw new UsernameNotFoundException(username);
             }
             return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());

		 
		 
		 
		 
		 
		 
	}

	}
