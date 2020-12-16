package com.vaescode.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vaescode.users.entities.User;
import com.vaescode.users.services.RoleService;

@RestController
@RequestMapping("/roles")
public class UserInRoleController {

	@Autowired
	private RoleService service; 
	
	@GetMapping("/{roleName}/users")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable("roleName") String roleName) {
		return new ResponseEntity<List<User>>(service.getUsersByRole(roleName), HttpStatus.OK);
	}
}
