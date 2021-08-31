package com.contact.repository.user.contact;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.contact.models.user.contact.Contact;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

	public Contact findByMobileNumberAndUserMobileNumber(String contactMobileNumber,String userMobile);
	public Contact findByMobileNumberAndUserEmail(String contactMobileNumber, String userEmail);
	public List<Contact> findByUserEmail(String str);
}
