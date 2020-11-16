package com.vaescode.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.users.entities.Profile;
import com.vaescode.users.services.ProfileService;

@RequestMapping("/users/{userId}/profiles")
@RestController
public class ProfileController {

	@Autowired
	public ProfileService service; 
	
	@PostMapping
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId ,@RequestBody Profile profile){
		return new ResponseEntity<Profile>(service.create(userId, profile), HttpStatus.CREATED);
	}
}
