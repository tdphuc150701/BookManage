package com.bookmanage.controller;

import com.bookmanage.dto.JwtRequest;
import com.bookmanage.dto.JwtResponse;
import com.bookmanage.dto.UserDTO;
import com.bookmanage.repository.UserRepository;
import com.bookmanage.service.AuthenticationService;
import com.bookmanage.service.impl.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.register(user));
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		String token = authenticationService.authenticate(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());
		return ResponseEntity.ok(new JwtResponse(token));
	}

}