package com.assignment.authentication.gng.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private GNGUserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		GNGUserDetails gngUserDetails = userDetailsRepository.getUser(userName);
		List<String> permissions= userDetailsRepository.getPermissionList(userName);
		List<GrantedAuthority> grantAuthorityList = new ArrayList<GrantedAuthority>();
		for(String permission:permissions) {
			GrantedAuthority ga = new SimpleGrantedAuthority(permission);
			grantAuthorityList.add(ga);
		}
		gngUserDetails.setGrantedAuthoritiesList(grantAuthorityList);
		if (gngUserDetails == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new CustomUser(gngUserDetails);
	}

}
