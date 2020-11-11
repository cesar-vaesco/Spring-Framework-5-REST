package com.vaescode.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.vaescode.users.models.User;

@Service
public class UserServiceList {

	@Autowired
	private Faker faker;

	private List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 100; i++) {
			users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
		}
	}

	public List<User> getUsers(String startWith) {
		
		if (startWith != null) {
			return users.stream().filter(u -> u.getUserName().startsWith(startWith)).collect(Collectors.toList());
		} else {

			return users;
		}
	}

	public User getUserByUsername(String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny().orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
	}

	public User createUser(User user) {

		// Validar que no exista ya un usuario registrado
		if (users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s already exist", user.getUserName()));
		}
		// Registrar un nuevo usuario
		users.add(user);
		return user;
	}
	
	public User updateUser(User user, String username) {
		User userToBeUpdate = getUserByUsername(username);
		userToBeUpdate.setNickName(user.getNickName());
		//userToBeUpdate.setUserName(user.getUserName());
		userToBeUpdate.setPassword(user.getPassword());
		
		return userToBeUpdate;
		
	}
	
	public void deleteUser(String username ) {
		User userDelete = getUserByUsername(username);
		users.remove(userDelete);
	}

	
}
