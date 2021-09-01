package com.contact.controllers.user.contact;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.models.user.User;
import com.contact.models.user.contact.Contact;
import com.contact.repository.user.UserRepository;
import com.contact.repository.user.contact.ContactRepository;
import com.contact.services.user.contact.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContactService contactService;
	
	     @PostMapping("/add_contact")
	     public ResponseEntity<?> addContact(@RequestBody Contact contact)
	     {
	    	 
	    	 
	    	 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
		                .getPrincipal();
	        	String username = userDetails.getUsername();
	        	Contact tempContact = null;
//	        	int count = 0;
//	       if(StringUtils.isNumeric(username))
//	       {
//	    	   ++count;
//	    	 tempContact =   this.contactRepository.findByMobileNumberAndUserMobileNumber(contact.getMobileNumber(), username);   
//	       }else {
			 tempContact = this.contactRepository.findByMobileNumberAndUserEmail(contact.getMobileNumber(), username);
			 System.out.println(tempContact);
//		}
	       if(tempContact != null)
	       {
	    	  return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
	       }else {
	    	       	
	    	        	
	    	        	User u = this.userRepository.findByEmail(username);
	    	        	contact.setUserEmail(username);
	    	        	contact.setUserMobileNumber(u.getMobileNumber());
	    	        
	    	        
	    	        if(this.contactService.addContact(contact) != null)
	    	        {
	    	        	return ResponseEntity.status(HttpStatus.OK).build();
	    	        }else {
	    	        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    	        }
	    	        
	    	        
	       }
		
	       
	     }
	     
	     
	     
	     @GetMapping("get_contacts")
	     public ResponseEntity<?> getContacts()
	     {
	    	 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
		                .getPrincipal();
	        	String username = userDetails.getUsername();
	        	
	    	 List<Contact> list = null;
	    	 
	    	 list = this.contactService.getContacts(username);
	    	 if(list.size() != 0)
	    	 {
	    		 return ResponseEntity.status(HttpStatus.OK).body(list);
	    	 }else {
	    		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    	 }
	     }
	     
	     
	     @PostMapping("/delete/{mobileNumber}")
	     public ResponseEntity<?> deleteContact(@PathVariable("mobileNumber") String mobileNumber)
	     {
	    	 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
		                .getPrincipal();
	        	String username = userDetails.getUsername();
	        	try {
	    	      this.contactService.deleteContact(mobileNumber, username);
	        	}
	        	catch (Exception e) {
					e.printStackTrace();
					
				}
	    	      return ResponseEntity.status(HttpStatus.OK).build();
	     }
	     

}
