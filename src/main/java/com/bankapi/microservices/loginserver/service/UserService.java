package com.bankapi.microservices.loginserver.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.loginserver.entity.User;
import com.bankapi.microservices.loginserver.jwt.JwtTokenProvider;
import com.bankapi.microservices.loginserver.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	
	@Transactional(readOnly = true)
	public void Save(User user) {
		userRepository.saveAndFlush(user);
	}
	@Transactional(readOnly = true)
	public String signIn(User user) throws Exception {
		boolean exists = userRepository.existsByEmailAddressAndPassword(user.getEmailAddress(), user.getPassword());
       if(!exists) throw new Exception("Incorrect user credentials");
		String jwtToken = jwtTokenProvider.createToken(user.getEmailAddress());
        return jwtToken;
	}
	
}
