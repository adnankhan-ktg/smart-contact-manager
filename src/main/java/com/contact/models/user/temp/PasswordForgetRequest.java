package com.contact.models.user.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordForgetRequest {
 
	 private String username;
	 private String password;
	 private String otp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public PasswordForgetRequest(String username, String password, String otp) {
		super();
		this.username = username;
		this.password = password;
		this.otp = otp;
	}
	public PasswordForgetRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PasswordForgetRequest [username=" + username + ", password=" + password + ", otp=" + otp + "]";
	}
	 
	 
	 
}
