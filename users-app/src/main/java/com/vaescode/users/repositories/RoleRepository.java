package com.vaescode.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaescode.users.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
