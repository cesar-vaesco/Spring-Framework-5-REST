package com.vaescode.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.users.entities.User;
import com.vaescode.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
	}

	// http://localhost:8080/users/username/{username}
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		return new ResponseEntity<>(service.getUserByUsername(username), HttpStatus.OK);
	}

	// http://localhost:8080/users/password/{username}
	@GetMapping("/password/{password}")
	public ResponseEntity<User> getUserByPassword(@PathVariable("password") String password) {
		return new ResponseEntity<>(service.getUserByPassword(password), HttpStatus.OK);
	}

	// http://localhost:8080/users   -> se pasa por cuerpo de la petición todos los atributos del objeto
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		return new ResponseEntity<>(service.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()),
				HttpStatus.OK);
	}
}
