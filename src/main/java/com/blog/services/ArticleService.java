package com.blog.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blog.dtos.ArticleDto;
import com.blog.dtos.ArticleDto.GetAllApprovedArticles;
import com.blog.entities.Articles;
import com.blog.entities.User;
import com.blog.entities.VersionHistory;
import com.blog.repository.ArticleRepository;
import com.blog.repository.UserRepository;
import com.blog.repository.VersionHistoryRepository;

@Service
public class ArticleService {
	
	@Autowired
	private VersionHistoryRepository versionHistoryRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
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
	    versionHistory.setUser(foundUser);
	    
	    versionHistoryRepository.save(versionHistory);
	    
		return new ResponseEntity<>("Created New Article", HttpStatus.OK);
	}
	
	public ResponseEntity<?> createNewVersion(ArticleDto.CreateNewVersion createNewVersion){
		
		VersionHistory getAllVersions = versionHistoryRepository.getReferenceById(createNewVersion.getVersionId());
	
		// check if there are any pending states
		List<Articles> getPendingVersions = getAllVersions.getArticleSet().stream().filter((article)->article.getStatus().equals("pending")).collect(Collectors.toList());
		if(getPendingVersions.size() > 0) return new ResponseEntity<>("Kindly wait for the previous pending state to be completed", HttpStatus.BAD_REQUEST);
		
		// fetch latest approved version
		List<Articles> getAllApprovedVersions = getAllVersions.getArticleSet().stream().filter((article)->article.getStatus().equals("approved")).collect(Collectors.toList());
		Articles maxLatestVersion;
		if(getAllApprovedVersions.size() == 0 ) {
			maxLatestVersion = null;
		} else {
		maxLatestVersion = getAllApprovedVersions.stream().max((a,b)->{
			if(a.getVersionNumber() > b.getVersionNumber()) {
				return 1;
			} else return -1;
			}).get();
		}
		
		// set new pending version
		Articles createNewArticle;
		if(maxLatestVersion != null) {
			createNewArticle = new Articles("11111", maxLatestVersion.getVersionNumber()+1, createNewVersion.getTitle(), createNewVersion.getContent(), null, "pending");
		}
		else {
			createNewArticle = new Articles("11111", 1 , createNewVersion.getTitle(), createNewVersion.getContent(), null, "pending");
		}
		createNewArticle.setVersionHistory(versionHistoryRepository.getReferenceById(createNewVersion.getVersionId()));
		articleRepository.save(createNewArticle);
		return new ResponseEntity<>("created new article version", HttpStatus.OK);
	}
	
	public ResponseEntity<?> updateArticleStatus(ArticleDto.UpdateArticleStatus updateArticleStatus){
		Articles updatedArticle = articleRepository.getReferenceById(updateArticleStatus.getArticleId());
		System.out.println("current status is: "+ updatedArticle.getStatus());
		// if status is rejected straight away update it in the given article id else first get all approved/pending articles and set their status to rejected then set it to approve(Reason: only one article will have approved state at a time)
		if(updateArticleStatus.getStatus().equals("rejected")) {
			updatedArticle.setStatus("rejected");
			articleRepository.save(updatedArticle);
		}
		else {
			VersionHistory getVersions = versionHistoryRepository.getReferenceById(updatedArticle.getVersionHistory().getVersionId());
			Set<Articles> getAllCompleteStates = getVersions.getArticleSet().stream().
					filter((article)-> article.getStatus().equals("approved"))
					.collect(Collectors.toSet());
			for(Articles a : getAllCompleteStates) {
				a.setStatus("rejected");
			}
			versionHistoryRepository.save(getVersions);
			updatedArticle.setStatus("approved");
			articleRepository.save(updatedArticle);
		}
		return new ResponseEntity<>("Status set",HttpStatus.OK);
	}
	
	public ResponseEntity<?> getLatestArticles(){
		List<VersionHistory> allArticleVersions = versionHistoryRepository.findAll();
		List<ArticleDto.GetAllApprovedArticles> approvedArticles = new ArrayList<>();
		
		for(VersionHistory v : allArticleVersions) {
			List<Articles> approvedVersions = v.getArticleSet().stream().filter((article)-> article.getStatus().equals("approved")).collect(Collectors.toList());
			if(approvedVersions.size() > 0) {
			  GetAllApprovedArticles approvedArticle = new GetAllApprovedArticles();
			  approvedArticle.setContent(approvedVersions.get(0).getContent());
			  approvedArticle.setTitle(approvedVersions.get(0).getTitle());
			  approvedArticles.add(approvedArticle);
			}
		}
		
		return new ResponseEntity<>(approvedArticles,HttpStatus.OK);
	}

}
