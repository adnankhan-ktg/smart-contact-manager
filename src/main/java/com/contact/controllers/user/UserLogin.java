package com.contact.controllers.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.models.user.User;
import com.contact.models.user.temp.JwtRequest;
import com.contact.repository.user.UserRepository;
import com.contact.security.config.JwtTokenUtil;
import com.contact.services.temp.JwtUserDetailsService;



@RestController
@CrossOrigin
public class UserLogin {
	private static final Logger log = LoggerFactory.getLogger(UserLogin.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest request)
	{
		User u = this.userRepository.findByUsername(request.getUsername());
//		if(this.userRepository.findByUsername(request.getUsername()) != null)
		if(u != null)
		{
//			System.out.println(passwordEncoder.matches(request.getPassword(), u.getPassword()));
//			User tempUser = this.userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		
			if(passwordEncoder.matches(request.getPassword(), u.getPassword()))
			{
				final UserDetails userDetails  = this.jwtUserDetailsService.loadUserByUsername(request.getUsername());
				String token = this.jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.status(HttpStatus.OK).body(token);
				
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}

}
