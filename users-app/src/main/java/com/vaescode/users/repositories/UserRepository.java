package com.vaescode.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	 * @param pageRequest 
	 * */
	@Query("SELECT u.username FROM User u")
	public Page<String> findUsernames(Pageable pageable);
	
	/*
	 * Ejemplos de Custom Querys
	 * 
	 * @Query("SELECT u.username FROM User u WHERE username like '%collins'") -> todos los registros que contengan collins
	 * @Query("SELECT u.username FROM User u WHERE username like '%c'") -> todos los usuarios que sus registros acaben en c
	 * 
	 * */
	


}
