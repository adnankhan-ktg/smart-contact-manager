package com.contact.models.user.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	
	private String email;
	private String mobileNumber;
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
	public Request(String email, String mobileNumber) {
		super();
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Request [email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}

    
}
