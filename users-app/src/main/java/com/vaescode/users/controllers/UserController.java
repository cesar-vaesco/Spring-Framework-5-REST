package com.vaescode.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.users.entities.User;
import com.vaescode.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	/*
	 * http://localhost:8080/users?page=1&size=1000 Se indica la pagina a ver y
	 * cantidad de registros que se van a ver en las páginas
	 */

	/*
	 * http://localhost:8080/users -> al agregar a los parametros valores de
	 * inicialización se puede mostrar la paginación con valores por default PAra el
	 * ejemplo se inicializaron 100000 registros y por default se inicia en la
	 * página 0 y esta página muestra 1000 registros
	 * 
	 */
	
	/*LA lista es de String por que los datos que se van a listar son datos de tipo String*/
	@GetMapping("/usernames")
	public ResponseEntity <List<String>> getUsernames(){
		return new ResponseEntity<>( service.getUsernames(),HttpStatus.OK) ;
	}
	

	@GetMapping
	public ResponseEntity<Page<User>> getUsers(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "1000") int size) {
		return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
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

	// http://localhost:8080/users -> se pasa por cuerpo de la petición todos los
	// atributos del objeto
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user) {
		return new ResponseEntity<>(service.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()),
				HttpStatus.OK);
	}
}
