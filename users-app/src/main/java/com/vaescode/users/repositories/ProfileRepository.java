package com.vaescode.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaescode.users.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
