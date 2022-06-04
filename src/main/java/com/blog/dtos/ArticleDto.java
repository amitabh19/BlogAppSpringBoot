package com.blog.dtos;

import java.util.List;
import java.util.Objects;

import com.blog.entities.Articles;

public class ArticleDto {

		public static class CreateArticle {
			private String username;
			private String title;
			private String content;
			private String status;
			private Integer version;
			
			public Integer getVersion() {
				return version;
			}
			public void setVersion(Integer version) {
				this.version = version;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			
		}
		
		public static class CreateNewVersion {
			private Long versionId;
			private String title;
			private String content;
			private String date;
			public Long getVersionId() {
				return versionId;
			}
			public void setVersionId(Long versionId) {
				this.versionId = versionId;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			
		}
		
		public static class UpdateArticleStatus{
			private Long articleId;
			private String status;
			public Long getArticleId() {
				return articleId;
			}
			public void setArticleId(Long articleId) {
				this.articleId = articleId;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			
		}
		
		public static class GetAllApprovedArticles {
			private String title;
			private String content;
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			
		}
}
