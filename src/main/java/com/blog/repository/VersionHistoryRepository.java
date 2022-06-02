package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.VersionHistory;

public interface VersionHistoryRepository extends JpaRepository<VersionHistory, Long> {

}
