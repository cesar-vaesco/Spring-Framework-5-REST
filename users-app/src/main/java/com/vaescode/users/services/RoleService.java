package com.vaescode.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaescode.users.entities.Role;
import com.vaescode.users.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public List<Role> getRoles() {

		/*
		 * 
		 * Usando CrudRepository se tiene que castear la respuesta: (List<Role>)
		 * repository.findAll(); o asignar la respuesta un Iterable Iterable <Role>
		 * findAll = repository.findAll(); USando JpaRepository se puede utilizar el
		 * método List<T> findAll() y con ello no hay necesidad de castear el retorno
		 */
		return repository.findAll();
	}

	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	


	
	public Role updateRole(Integer roleId, Role role) {
		
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			return repository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn´t exist", roleId));
		}

	}

	public void deleteRole(Integer id) {
		Optional<Role> result = repository.findById(id);
		if (result.isPresent()) {
			repository.deleteById(id);			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn´t exist", id));
		}
	}

	
	/*
	 * public void deleteUser(String username ) { User userDelete =
	 * getUserByUsername(username); users.remove(userDelete); }
	 */
}
