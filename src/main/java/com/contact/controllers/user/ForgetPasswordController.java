package com.contact.controllers.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.models.user.User;
import com.contact.models.user.temp.MailRequest;
import com.contact.models.user.temp.PasswordForgetRequest;
import com.contact.models.user.temp.UpdatePassword;
import com.contact.services.temp.MailService;
import com.contact.services.temp.OtpService;
import com.contact.services.user.UserService;

@RestController
public class ForgetPasswordController {
	
	private static final Logger log = LoggerFactory.getLogger(ForgetPasswordController.class);
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	  @PostMapping("/get_passwordforget_otp")
	   public ResponseEntity<?> getOtp(@RequestBody PasswordForgetRequest request)
	   {
		  User user = null;
		      user = this.userService.getUser(request.getUsername());
          if(user != null)
          {
       	   MailRequest mailRequest = new MailRequest();
       	   int GeneratedOtp = otpService.generateOTP(user.getEmail());
      		   String GeneratedOtpString = Integer.toString(GeneratedOtp);
      		   mailRequest.setMessage("Your Exam-Portal Username Id password forget otp ( "+GeneratedOtpString+" )");
      		   mailRequest.setReceiverAddress(user.getEmail());
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
			     user = this.userService.getUser(request.getUsername());
			if(user != null)
			{
				int serverOtp = otpService.getOtp(user.getEmail());
		    	  int clientOtp = Integer.parseInt(request.getOtp());
		    	  if(serverOtp == clientOtp)
		    	  {
		    		  otpService.clearOTP(user.getEmail());
		    		  return ResponseEntity.status(HttpStatus.OK).body("*1*1");
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
			    user = this.userService.getUser(updatePassword.getUsername());
		    if(user != null)
		    {
		    	if(updatePassword.getId().equals("*1*1") == true)
		    	{
	                                                    	    		
		    		user.setPassword(this.passwordEncoder.encode(updatePassword.getPassword()));
	    	    	User user12 = this.userService.updatePassword(user);
	                 if(user12 != null)
	    	    	return ResponseEntity.status(HttpStatus.OK).build();
	                 else {
	                	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	                 }
		    	}
		    }
		    
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	   }
	

}
