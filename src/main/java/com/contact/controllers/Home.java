package com.contact.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@GetMapping("/")
	public String home()
	{
		return "This is adnan khan";
	}

}
