package org.ahmadiyya.halqa.software.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthManager implements AuthenticationManager {
	
	@Autowired
	private UserDetailsService userService;

	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		String username = (String) auth.getPrincipal();
		String password = (String) auth.getCredentials();
		UserDetails user = userService.loadUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			Collection<? extends GrantedAuthority> authorities = user
					.getAuthorities();
			return new UsernamePasswordAuthenticationToken(username, password,
					authorities);
		}
		throw new BadCredentialsException("Bad Credentials");
	}
}
