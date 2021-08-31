package com.contact.models.user;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String id;
	private String email;
	private String mobileNumber;
	private String password;
	private String firstName;
	private String lastName;
	private String role = "NORMAL";
	private String image;
	private String about;
	private boolean enable = true;
	private String otp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public User(String id, String email, String mobileNumber, String password, String firstName, String lastName,
			String role, String image, String about, boolean enable, String otp) {
		super();
		this.id = id;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.image = image;
		this.about = about;
		this.enable = enable;
		this.otp = otp;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", image=" + image
				+ ", about=" + about + ", enable=" + enable + ", otp=" + otp + "]";
	}
	
	
	
	

	
}
