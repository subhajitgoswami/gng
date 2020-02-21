package com.assignment.twofactor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TwofactorDaoService {

	@Autowired
	GNGUserDetailsRepository gngUserDetailsRepository;

	public void updateTwofaProperties(String name, String twofaCode) {
		gngUserDetailsRepository.updateTwofaProperties(name, twofaCode);
	}
}
