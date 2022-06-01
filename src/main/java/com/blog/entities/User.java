package com.blog.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user2")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long userid;
	private String username;
	private String password;
	private String securityQues;
	private String role;
	

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="user_id")
	private Set<Articles> listOfArticleIdsPublishedByUser;
	
	
	public User(Long userid, String username, String password, String securityQues, String role,
			Set<Articles> listOfArticleIdsPublishedByUser) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.securityQues = securityQues;
		this.role = role;
		this.listOfArticleIdsPublishedByUser = listOfArticleIdsPublishedByUser;
	}


	public Long getId() {
		return userid;
	}


	public void setId(Long userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSecurityQues() {
		return securityQues;
	}


	public void setSecurityQues(String securityQues) {
		this.securityQues = securityQues;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Set<Articles> getListOfArticleIdsPublishedByUser() {
		return listOfArticleIdsPublishedByUser;
	}


	public void setListOfArticleIdsPublishedByUser(Set<Articles> listOfArticleIdsPublishedByUser) {
		this.listOfArticleIdsPublishedByUser = listOfArticleIdsPublishedByUser;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", securityQues="
				+ securityQues + ", role=" + role + ", listOfArticleIdsPublishedByUser="
				+ listOfArticleIdsPublishedByUser + "]";
	}

}
