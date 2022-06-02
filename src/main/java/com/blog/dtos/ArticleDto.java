package com.blog.dtos;

import java.util.Objects;

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
}
