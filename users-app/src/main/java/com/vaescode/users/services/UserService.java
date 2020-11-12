package com.vaescode.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaescode.users.entities.User;
import com.vaescode.users.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getUsers(int page, int size) {
		return  userRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public List<String> getUsernames() {
		
		return userRepository.findUsernames();
	}


	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("USer %d not found", userId)));
	}

	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", username)));
	}
	
	public User getUserByPassword(String password) {
		return userRepository.findByPassword(password).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", password)));
	}
	
	public User getUserByUsernameAndPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", password)));
	}

	

	
}
