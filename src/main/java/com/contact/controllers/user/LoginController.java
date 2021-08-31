package com.contact.controllers.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.models.user.User;
import com.contact.models.user.temp.JwtRequest;
import com.contact.repository.user.UserRepository;
import com.contact.security.config.JwtTokenUtil;
import com.contact.services.temp.JwtUserDetailsService;
import com.contact.services.user.UserService;



@RestController
public class LoginController {
	
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserRepository userRepostory;
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetatilsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest request)
	{
		  User tempUser = null;
		if(StringUtils.isNumeric(request.getUsername()))
	    {
	    	tempUser = this.userRepostory.findByMobileNumber(request.getUsername());
	    	System.out.println("mobile");
	    }else {
	    	tempUser = this.userRepostory.findByEmail(request.getUsername());
	    	System.out.println("email");
	    }
		System.out.println("hello");
		
		if(tempUser == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			if(passwordEncoder.matches(request.getPassword(), tempUser.getPassword()))
			{
				final UserDetails userDetails  = this.jwtUserDetatilsService.loadUserByUsername(request.getUsername());
				String token = this.jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.status(HttpStatus.OK).body(token);
				
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		}
	}

}
