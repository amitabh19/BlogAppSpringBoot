package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Articles;

public interface ArticleRepository extends JpaRepository<Articles, Long> {

}
