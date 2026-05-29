package com.marketplace.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.auth.dto.AuthResponse;
import com.marketplace.auth.dto.LoginRequest;
import com.marketplace.auth.dto.RegisterRequest;
import com.marketplace.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {
		
		return authService.register(request);
	}
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		
		return authService.login(request);
	}
	
	@GetMapping("/test")
	public String testApi() {
		
		return  "JWT Token Valid. Protected API Accessed";
	}

}
