package com.marketplace.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketplace.auth.dto.AuthResponse;
import com.marketplace.auth.dto.LoginRequest;
import com.marketplace.auth.dto.RegisterRequest;
import com.marketplace.auth.entity.User;
import com.marketplace.auth.repository.UserRepository;
import com.marketplace.auth.util.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public String register(RegisterRequest request) {
		
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {

			return "Email already exists";
		}
		
		User user=User.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();
		
		userRepository.save(user);
		
		return "User Registered Successfully";
	}
	
	public AuthResponse login(LoginRequest request) {
		
		User user=userRepository.findByEmail(request.getEmail())
				.orElse(null);
		
		if(user == null) {
			
			 throw new RuntimeException("Invalid Email");
		}
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			
			throw new RuntimeException("Invalid Password");
		}
		
		String token=jwtUtil.generateToken(user.getEmail());
		
		return new AuthResponse(token);
	}

}
