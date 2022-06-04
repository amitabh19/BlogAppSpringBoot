package com.blog.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articles2")
public class Articles {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long articleId;
	private String articleNumber;
	private Integer versionNumber;
	private String title;
	private String content;
	private LocalDateTime publishedDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="article_set_version_id")
	private VersionHistory versionHistory;
	
	public Articles() {
		// TODO Auto-generated constructor stub
	}

	public VersionHistory getVersionHistory() {
		return versionHistory;
	}

	public void setVersionHistory(VersionHistory versionHistory) {
		this.versionHistory = versionHistory;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
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

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleId, articleNumber, content, publishedDate, status, title, versionNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articles other = (Articles) obj;
		return Objects.equals(articleId, other.articleId) && Objects.equals(articleNumber, other.articleNumber)
				&& Objects.equals(content, other.content) && Objects.equals(publishedDate, other.publishedDate)
				&& Objects.equals(status, other.status) && Objects.equals(title, other.title)
				&& Objects.equals(versionNumber, other.versionNumber);
	}

	@Override
	public String toString() {
		return "Articles [articleId=" + articleId + ", articleNumber=" + articleNumber + ", versionNumber="
				+ versionNumber + ", title=" + title + ", content=" + content + ", publishedDate=" + publishedDate
				+ ", status=" + status + "]";
	}

	public Articles(String articleNumber, Integer versionNumber, String title, String content,
			LocalDateTime publishedDate, String status) {
		super();
		this.articleNumber = articleNumber;
		this.versionNumber = versionNumber;
		this.title = title;
		this.content = content;
		this.publishedDate = publishedDate;
		this.status = status;
	}

}
