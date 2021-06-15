package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.LoginRequest;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class AuthController {
	
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public HashMap<String, String> getUserAuthenticated(@RequestBody LoginRequest loginRequest)throws Exception{
		Users users= new Users(loginRequest.getUsername(), loginRequest.getPassword());
		Users user= this.service.getUser(users);
		
		if(user==null) {
			throw new Exception("user not found: "+loginRequest.getUsername());
		}
		HashMap<String, String> response= new HashMap<String,String>();
		if(users.getPassword().equals(user.getPassword())) {
			Cookie cookie= new Cookie("username", user.getUsername());
			response.put("isAuthenticatedUser", "true");
			response.put("username", cookie.getValue());
		}
		else {
			response.put("isAuthenticatedUser", "false");
		}
		
		return response;
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody Users users){
		this.service.saveUser(users);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
