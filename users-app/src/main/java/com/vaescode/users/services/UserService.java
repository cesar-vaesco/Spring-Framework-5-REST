package com.vaescode.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaescode.users.entities.User;
import com.vaescode.users.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
}
