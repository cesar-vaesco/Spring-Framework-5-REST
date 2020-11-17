package com.vaescode.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaescode.users.entities.Address;
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

	/**
	 * public Profile getByUserAndProfileId(Integer userId, Integer profileId) { //
	 * TODO Auto-generated method stub return
	 * profileRepository.getByUserAndProfileId(userId, profileId) .orElseThrow(() ->
	 * new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile not
	 * found for user %d and profile %d", userId, profileId))); }
	 */
}
