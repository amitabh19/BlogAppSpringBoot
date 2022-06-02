package com.blog.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blog.dtos.ArticleDto;
import com.blog.entities.Articles;
import com.blog.entities.User;
import com.blog.entities.VersionHistory;
import com.blog.repository.UserRepository;
import com.blog.repository.VersionHistoryRepository;

@Service
public class ArticleService {
	
	@Autowired
	private VersionHistoryRepository versionHistoryRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public ResponseEntity<?> createArticle(ArticleDto.CreateArticle createArticle) {
		
		User foundUser = null;
		
		List<User> userList = userRepository.findAll();
		for(User u : userList) {
			if(u.getUsername().equals(createArticle.getUsername())) {
				foundUser = u;
			}
		}
		
		Articles atricle = new Articles("", createArticle.getVersion(), createArticle.getTitle(), createArticle.getContent(), null, createArticle.getStatus());
	    Set<Articles> articleSet = new HashSet<Articles>();
	    articleSet.add(atricle);
	    
	    VersionHistory versionHistory = new VersionHistory(articleSet);
	    Set<VersionHistory> versionHistorySet = new HashSet<VersionHistory>();
	    versionHistorySet.add(versionHistory);
	  
	    foundUser.setListOfArticleIdsPublishedByUser(versionHistorySet);
	    
	    userRepository.delete(userRepository.getReferenceById(foundUser.getId()));
	    userRepository.saveAndFlush(foundUser);
		return new ResponseEntity<>("Created New Article", HttpStatus.OK);
	}

}
