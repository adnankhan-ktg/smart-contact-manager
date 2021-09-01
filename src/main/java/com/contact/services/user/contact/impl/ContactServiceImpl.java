package com.contact.services.user.contact.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.models.user.contact.Contact;
import com.contact.repository.user.contact.ContactRepository;
import com.contact.services.user.contact.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private ContactRepository contactRepository;
	@Override
	public Contact addContact(Contact contact) {
       
		   Contact tempContact = null;
		   try {
	               tempContact = this.contactRepository.save(contact);
	               return tempContact;
		   }catch (Exception e) {
	              
			   e.printStackTrace();
			   return tempContact;
		}
		
	}
	@Override
	public List<Contact> getContacts(String id) {
		List<Contact> list = null;
		try {
			list = this.contactRepository.findByUserEmail(id);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return list;
		}
	}
	
	@Override
	public void deleteContact(String id, String email) {
	 
	   	Contact c =this.contactRepository.findByMobileNumberAndUserEmail(id, email);
	   	this.contactRepository.delete(c);
		
	}

}
