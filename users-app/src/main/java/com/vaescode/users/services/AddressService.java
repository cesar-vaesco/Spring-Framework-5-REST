package com.vaescode.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vaescode.users.entities.Address;
import com.vaescode.users.entities.Profile;
import com.vaescode.users.repositories.AddressRepository;
import com.vaescode.users.repositories.ProfileRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findAddressByProfileAndUserId(Integer userId, Integer profileId) {

		return addressRepository.findByProfileId(userId, profileId);
	}

	public Address createAddress(Integer userId, Integer profileId, Address address) {
		Optional<Profile> result = profileRepository.getByUserAndProfileId(userId, profileId);
		if (result.isPresent()) {

			address.setProfile(result.get());
			return addressRepository.save(address);
		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Profile %d and %d not found", profileId, userId));
		}

	}

	/**
	 * public Profile getByUserAndProfileId(Integer userId, Integer profileId) { //
	 * TODO Auto-generated method stub return
	 * profileRepository.getByUserAndProfileId(userId, profileId) .orElseThrow(() ->
	 * new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile not
	 * found for user %d and profile %d", userId, profileId))); }
	 */
}
