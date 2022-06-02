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
	private String securityAnswer;
	private String role;

	@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},orphanRemoval = true)
	@JoinColumn(name="user_id")
	private Set<VersionHistory> listOfArticleIdsPublishedByUser;
	
	
	

	public User( String username, String password, String securityQues, String securityAnswer, String role,
			Set<VersionHistory> listOfArticleIdsPublishedByUser) {
		super();
		this.username = username;
		this.password = password;
		this.securityQues = securityQues;
		this.securityAnswer = securityAnswer;
		this.role = role;
		this.listOfArticleIdsPublishedByUser = listOfArticleIdsPublishedByUser;
	}


	public String getSecurityAnswer() {
		return securityAnswer;
	}


	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
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


	public Set<VersionHistory> getListOfArticleIdsPublishedByUser() {
		return listOfArticleIdsPublishedByUser;
	}


	public void setListOfArticleIdsPublishedByUser(Set<VersionHistory> listOfArticleIdsPublishedByUser) {
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


	@Override
	public int hashCode() {
		return Objects.hash(listOfArticleIdsPublishedByUser, password, role, securityAnswer, securityQues, userid,
				username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(listOfArticleIdsPublishedByUser, other.listOfArticleIdsPublishedByUser)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(securityAnswer, other.securityAnswer)
				&& Objects.equals(securityQues, other.securityQues) && Objects.equals(userid, other.userid)
				&& Objects.equals(username, other.username);
	}
	

}
