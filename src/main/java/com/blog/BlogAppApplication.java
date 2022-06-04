package com.blog;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blog.entities.Articles;
import com.blog.entities.User;
import com.blog.entities.VersionHistory;
import com.blog.repository.UserRepository;
import com.blog.repository.VersionHistoryRepository;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
   
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private VersionHistoryRepository versionHistoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("helloooooo");
		
		// articles for user1
//		  Articles article1 = new Articles( "111", 1,"Sex Tape" , "AMY Santiago ", null,"approved" );
//		  Articles article2 = new Articles( "112", 2,"Sex Tape2" , "AMY Santiago2 ", null,"approved" );
//		  Articles article3 = new Articles( "111", 3,"Sex Tape3" , "AMY Santiago3 ", null,"approved" );
//		  Set<Articles> articleSet = new HashSet<Articles>();
//		  articleSet.add(article1);
//		  articleSet.add(article2);
//		  articleSet.add(article3);
//		  
//		  VersionHistory versionHistory = new VersionHistory(articleSet);
//		  Set<VersionHistory> versionHistorySet = new HashSet<VersionHistory>();
//		  versionHistorySet.add(versionHistory);
//		  
//		  User user1 = new User("amitasax", "bitch", "who's chudail?","It izzzz what it izzzz", "admin",versionHistorySet );
//		  userRepository.save(user1);
//		  
//		  // articles for user2
//		  Articles article21 = new Articles( "111", 1,"Avengers1" , "This is avengers1 ", null,"approved" );
//		  Articles article22 = new Articles( "112", 2,"Avengers2" , "This is avengers1 ", null,"rejected" );
//		  Articles article23 = new Articles( "111", 3,"Avengers3" , "This is avengers1 ", null,"pending" );
//		  Set<Articles> articleSet2 = new HashSet<Articles>();
//		  articleSet2.add(article21);
//		  articleSet2.add(article22);
//		  articleSet2.add(article23);
//		  
//		  VersionHistory versionHistory2 = new VersionHistory(articleSet2);
//		  Set<VersionHistory> versionHistorySet2 = new HashSet<VersionHistory>();
//		  versionHistorySet2.add(versionHistory2);
//		  
//		  User user2 = new User( "simphunter", "bitch", "who's chudail?", "it izzz what it izzz", "admin",versionHistorySet2 );
//		  userRepository.save(user2);
	}

}
