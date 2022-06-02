package com.blog.dtos;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class UserDto {
    
	public static class CreateUser {
	private String username;
	private String password;
	private String securityQuestion;
	private String securityAnswer;
	private String role;
	
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
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CreateUser [username=" + username + ", password=" + password
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + ", role=" + role
				+ "]";
	}
	
	
	}
    
	public static class LoginUser {
		private String username;
		private String password;
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
		@Override
		public int hashCode() {
			return Objects.hash(password, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoginUser other = (LoginUser) obj;
			return Objects.equals(password, other.password) && Objects.equals(username, other.username);
		}
	}
	
	public static class LoginResponse{
		String username;
		String role;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public int hashCode() {
			return Objects.hash(role, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoginResponse other = (LoginResponse) obj;
			return Objects.equals(role, other.role) && Objects.equals(username, other.username);
		}
		
	}
	
	
}
