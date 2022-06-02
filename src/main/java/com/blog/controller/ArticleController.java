package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dtos.ArticleDto;
import com.blog.services.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/getAllArticles")
	public ResponseEntity<?> getLatestArticles(){
		return null;
	}
	
	@PostMapping("/createArticle")
	public ResponseEntity<?> createArticle(@RequestBody ArticleDto.CreateArticle craeteArticle){
		return articleService.createArticle(craeteArticle);
	}

}
