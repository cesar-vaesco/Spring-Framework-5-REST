package com.vaescode.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaescode.users.entities.User;
import com.vaescode.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {

	@Query("SELECT u.user FROM UserInRole u WHERE u.role.name=?1") 
	public List<User> findUsersByRole(String roleName);
}
