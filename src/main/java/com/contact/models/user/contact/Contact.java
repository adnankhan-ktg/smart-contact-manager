package com.contact.models.user.contact;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {
   
	
	@Id
	private String cId;
	private String mobileNumber;
	private String firstName;
	private String lastName;
	private String nickName;
	private String work;
	private String email;
	private String image;
	private String description;
	private String userMobileNumber;
	private String userEmail;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Contact(String cId, String mobileNumber, String firstName, String lastName, String nickName, String work,
			String email, String image, String description, String userMobileNumber, String userEmail) {
		super();
		this.cId = cId;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.work = work;
		this.email = email;
		this.image = image;
		this.description = description;
		this.userMobileNumber = userMobileNumber;
		this.userEmail = userEmail;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", mobileNumber=" + mobileNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", nickName=" + nickName + ", work=" + work + ", email=" + email + ", image=" + image
				+ ", description=" + description + ", userMobileNumber=" + userMobileNumber + ", userEmail=" + userEmail
				+ "]";
	}
	
	
	
	

  
	   
}
