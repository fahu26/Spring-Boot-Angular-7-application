package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Users getUser(Users users) {
		return repository.findById(users.getUsername()).get();
		//return repository.findByEmail(users.getEmail());
	}
	
	public void saveUser(Users users) {
		repository.save(users);
	}
	
}
