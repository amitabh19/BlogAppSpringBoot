package com.blog.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="version_history")
public class VersionHistory {
	
	@Id
	@GeneratedValue
	private Long versionId;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn
	private Set<Articles> articleSet;
	
	public VersionHistory() {
		// TODO Auto-generated constructor stub
		
	}

	
	public Long getVersionId() {
		return versionId;
	}


	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}


	public Set<Articles> getArticleSet() {
		return articleSet;
	}

	public void setArticleSet(Set<Articles> articleSet) {
		this.articleSet = articleSet;
	}

	public VersionHistory(Set<Articles> articleSet) {
		super();
		this.articleSet = articleSet;
	}

}
