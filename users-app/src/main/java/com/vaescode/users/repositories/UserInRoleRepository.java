package com.vaescode.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaescode.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {

}
