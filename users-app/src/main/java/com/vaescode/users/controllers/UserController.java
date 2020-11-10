package com.vaescode.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.users.models.User;
import com.vaescode.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*Los métodos utilizados para solicitar un recurso se llaman handler method
	 * los cuales estan compuesos por un método HTTP y un recurso*/
	@GetMapping
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
}