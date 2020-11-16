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

import com.vaescode.users.entities.Profile;
import com.vaescode.users.services.ProfileService;

@RequestMapping("/users/{userId}/profiles")
@RestController
public class ProfileController {

	@Autowired
	public ProfileService service;

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getById(@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId) {
		return new ResponseEntity<Profile>(service.getByUserAndProfileId(userId, profileId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Profile>> getProfiles() {
		return new ResponseEntity<List<Profile>>(service.getProfiles(), HttpStatus.OK);
	}

	/*
	 * 
	 * Se pasan como parametros:
	 * 
	 * "firstName": "nombre", "lastName": "apellido", "birthDate":
	 * "1980-05-25T00:00:00.000+00:00",
	 */

	@PostMapping
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile) {
		return new ResponseEntity<Profile>(service.create(userId, profile), HttpStatus.CREATED);
	}
}
