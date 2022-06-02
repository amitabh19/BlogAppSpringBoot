package com.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blog.dtos.UserDto;
import com.blog.entities.User;
import com.blog.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<?> registerUser(UserDto.CreateUser userDto){
		
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setSecurityQues(userDto.getSecurityQuestion());
		user.setSecurityAnswer(userDto.getSecurityAnswer());
		user.setRole(userDto.getRole());
		
		boolean userExists = checkIfUserExists(user);
		
		if(!userExists) {
			User savedUser = userRepository.save(user);
		     
			System.out.println("User saved in service"+ savedUser);
			
			ResponseEntity<?> response = new ResponseEntity<>("User saved", HttpStatus.OK);
			return response;
		} else {
			System.out.println("Already there");
			return new ResponseEntity<>("Already Exists", HttpStatus.BAD_REQUEST);
		}
	
	}
	
	public ResponseEntity<?> loginUser(UserDto.LoginUser loginUser){
		
		User foundUser = null;
		List<User> users = userRepository.findAll();
		for(User u: users) {
			if(u.getUsername().equals(loginUser.getUsername()) && u.getPassword().equals(loginUser.getPassword())) {
				foundUser = u;
			}
		}
		
		if(foundUser == null) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		else {
			UserDto.LoginResponse userDetails = new UserDto.LoginResponse();
			userDetails.setRole(foundUser.getRole());
			userDetails.setUsername(foundUser.getUsername());
			return new ResponseEntity<>(userDetails,HttpStatus.OK);
		}
		
	}
	
	private Boolean checkIfUserExists(User user) {
		List<User> users = userRepository.findAll();
		for(User u: users) {
			if(u.getUsername().equals(user.getUsername())) return true;
		}
		return false;
	}

}
