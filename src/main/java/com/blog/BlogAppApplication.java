package com.blog;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.entities.Articles;
import com.blog.entities.User;
import com.blog.repository.UserRepository;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
   
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("helloooooo");
		  Articles article1 = new Articles(333l, "111", 1,"Sex Tape" , "AMY Santiago ", null,"approved" );
		  Set<Articles> articleSet = new HashSet<Articles>();
		  articleSet.add(article1);
		  User user1 = new User(13131L, "amitasax", "bitch", "who's chudail?", "admin",articleSet );
		  userRepository.save(user1);
		 
	}

}
