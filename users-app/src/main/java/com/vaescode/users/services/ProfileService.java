package com.vaescode.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaescode.users.entities.Profile;
import com.vaescode.users.entities.User;
import com.vaescode.users.repositories.ProfileRepository;
import com.vaescode.users.repositories.UserRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;

	public Profile create(Integer userId, Profile profile) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			profile.setUser(result.get());
			return profileRepository.save(profile);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId));
		}
	}

	public List<Profile> getProfiles() {
		return (List<Profile>) profileRepository.findAll();
	}

	public Profile getByUserAndProfileId(Integer userId, Integer profileId) {
		// TODO Auto-generated method stub
		return profileRepository.getByUserAndProfileId(userId, profileId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Profile not found for user %d and profile %d", userId, profileId)));
	}
	
}

	
