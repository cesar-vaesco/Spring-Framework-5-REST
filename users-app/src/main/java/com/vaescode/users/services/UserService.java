package com.vaescode.users.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaescode.users.entities.User;
import com.vaescode.users.repositories.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public Page<User> getUsers(int page, int size) {
		return userRepository.findAll(PageRequest.of(page, size));

	}

	public Page<String> getUsernames(int page, int size) {
		return userRepository.findUsernames(PageRequest.of(page, size));
	}

	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("USer %d not found", userId)));
	}

	@Cacheable("users")
	public User getUserByUsername(String username) {
		log.info("Getting user by username {}", username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userRepository.findByUsername(username).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
	}

	@CacheEvict("users")
	public void deleteUserByUsername(String username) {
		User user = getUserByUsername(username);
		userRepository.delete(user);
	}

	public User getUserByPassword(String password) {
		return userRepository.findByPassword(password).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", password)));
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", password)));
	}

}
