package com.vaescode.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.users.models.User;
import com.vaescode.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * podemos usar @RequestParam para extraer parámetros de consulta,
	 *  parámetros de formulario e incluso archivos de la solicitud.
	 * 
	 * Al método getUsers se ha agregado un parametro para buscar segun determinado dato de consulta
	 *  o buscando filtar información
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsers(@RequestParam(value= "startWith", required = false) String startWith) {
		return new ResponseEntity<List<User>>(userService.getUsers(startWith), HttpStatus.OK);
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	/*
	 * Aunque se quiera modificar el username, la aplicación toma el nombre pasado
	 * como parametro y lo persiste en el cuerpo de la petición: este método puede
	 * modificar los datos de nickname y password pero no el de el usuario
	 */
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
