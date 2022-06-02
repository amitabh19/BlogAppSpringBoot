package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dtos.UserDto;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDto.CreateUser userDto){
		return userService.registerUser(userDto);
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDto.LoginUser loginDetails){
		return userService.loginUser(loginDetails);
	}

}
