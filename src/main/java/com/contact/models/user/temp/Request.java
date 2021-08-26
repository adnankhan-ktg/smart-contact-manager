package com.contact.models.user.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Request(String username) {
		super();
		this.username = username;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Request [username=" + username + "]";
	}
	
	

}
