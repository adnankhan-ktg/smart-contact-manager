package com.contact.services.user.contact;

import java.util.List;

import com.contact.models.user.contact.Contact;

public interface ContactService {
	
	public Contact addContact(Contact contact);
	public List<Contact> getContacts(String id);
	

}
