package com.vaescode.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaescode.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);

	public Optional<User> findByPassword(String password);
	
	public Optional<User> findByUsernameAndPassword(String username,String password);

	/**
	 * Esto No es SQL se llama JPQL(Java Persisted Query Lenguaje) 
	 * */
	@Query("SELECT u.username FROM User u")
	public List<String> findUsernames();
	
	


}
