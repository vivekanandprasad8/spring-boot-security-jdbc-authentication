package io.vivek.springbootsecurity.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.vivek.springbootsecurity.model.User;

@RestController
public class HomeContoller {
	
	@GetMapping("/hello")
	public String getHello() {
		return "<h1>Hello World</h1>";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "<h1>Hello User</h1>";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "<h1>Hello Admin</h1>";
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		//User savedUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getUsername()).toUri();
		return ResponseEntity.created(location).build();
	}

}
