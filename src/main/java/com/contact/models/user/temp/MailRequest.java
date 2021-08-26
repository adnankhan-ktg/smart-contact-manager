package com.contact.models.user.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
	private String receiverAddress;
	private String message;
	private String subject;
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MailRequest(String receiverAddress, String message, String subject) {
		super();
		this.receiverAddress = receiverAddress;
		this.message = message;
		this.subject = subject;
	}
	public MailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MailRequest [receiverAddress=" + receiverAddress + ", message=" + message + ", subject=" + subject
				+ "]";
	}

	
}
