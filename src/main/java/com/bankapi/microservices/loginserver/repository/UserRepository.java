package com.bankapi.microservices.loginserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bankapi.microservices.loginserver.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional(readOnly = true)
	boolean existsByEmailAddressAndPassword(String emailAddress,String password);
	
}
