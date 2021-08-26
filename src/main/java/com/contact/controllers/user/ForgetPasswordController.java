package com.contact.controllers.user;

import java.lang.ref.Cleaner.Cleanable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.models.user.User;
import com.contact.models.user.temp.MailRequest;
import com.contact.models.user.temp.PasswordForgetRequest;
import com.contact.models.user.temp.UpdatePassword;
import com.contact.repository.user.UserRepository;
import com.contact.services.temp.MailService;
import com.contact.services.temp.OtpService;
import com.contact.services.user.UserService;


@RestController
@CrossOrigin
public class ForgetPasswordController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OtpService otpService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/get_passwordforget_otp")
	public ResponseEntity<?> getPasswordForgetOtp(@RequestBody PasswordForgetRequest request)
	{
	
		User user = null;
               user = this.userRepository.findByUsername(request.getUsername());
               if(user != null)
               {
            	   MailRequest mailRequest = new MailRequest();
            	   int GeneratedOtp = otpService.generateOTP(request.getUsername());
           		   String GeneratedOtpString = Integer.toString(GeneratedOtp);
           		   mailRequest.setMessage("Your Exam-Portal Username Id password forget otp ("+GeneratedOtpString+")");
           		   mailRequest.setReceiverAddress(request.getUsername());
           		   mailRequest.setSubject("OTP for forget account password");
           		   mailService.sendemail(mailRequest);
           		   return ResponseEntity.status(HttpStatus.OK).build();
           		   
           		
               }
               else {
            	   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            	    
               }
    }
	
	
	@PostMapping("/validate_otp")
	public ResponseEntity<?> validateOtp(@RequestBody PasswordForgetRequest request)
	{
		User user = null;
		user = this.userRepository.findByUsername(request.getUsername());
		if(user != null)
		{
			int serverOtp = otpService.getOtp(request.getUsername());
	    	  int clientOtp = Integer.parseInt(request.getOtp());
	    	  if(serverOtp == clientOtp)
	    	  {
	    		  otpService.clearOTP(request.getUsername());
	    		  return ResponseEntity.status(HttpStatus.OK).body(user.getFirstName());
	    	  }
	    	  else {
	    		  return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	    	  }
	    	  
		}else
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/update_password")
	public ResponseEntity<?> updatePassword(@RequestBody UpdatePassword updatePassword)
	{
		User user = null;
		 user = this.userRepository.findByUsername(updatePassword.getUsername());
	    if(user != null)
	    {
	    	if(updatePassword.getId().equals(user.getFirstName()) == true)
	    	{
                                                    	    		
	    		user.setPassword(this.passwordEncoder.encode(updatePassword.getPassword()));
    	    	User user12 = this.userService.updatePassword(user);
   
    	    	return ResponseEntity.status(HttpStatus.OK).build();
	    	}
	    }
	    
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
		
	 
}	
	
               
               

	
	

