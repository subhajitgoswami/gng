package com.assignment.authentication.gng.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class GNGUserController {
	private GNGUserDetailsRepository userDetailsRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public GNGUserController(GNGUserDetailsRepository userDetailsRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsRepository = userDetailsRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody GNGUserDetails user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDetailsRepository.save(user);
	}
}
