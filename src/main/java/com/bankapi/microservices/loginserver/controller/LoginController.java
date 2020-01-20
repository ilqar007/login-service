package com.bankapi.microservices.loginserver.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.microservices.loginserver.entity.User;
import com.bankapi.microservices.loginserver.service.UserService;



@RestController
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	
	  @PostMapping(value = "signIn") 
	  public ResponseEntity<String>	  signIn(@RequestBody User user) throws Exception {
	  
	  String token = userService.signIn(user);
	  return ok().body(token);
			  }
	 
    
    @PostMapping(value = "signUp")
    public ResponseEntity<String> signUp(@RequestBody User user, HttpServletRequest request) {

        userService.Save(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @GetMapping("/hello")
	public String hello() {
		return "Hello world!!!";
	}
}
