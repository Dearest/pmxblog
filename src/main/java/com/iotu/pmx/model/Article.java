package com.iotu.pmx.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private User user;
	private String title;
	private String content;
	private String summary;
	private Date time;
	private Integer star;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(User user, String title, String content, String summary,
			Timestamp time, Integer star) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.setTime(time);
		this.star = star;
	}

	/** full constructor */
	public Article(User user, String title, String content, String summary,
			Timestamp time, Integer star, Set comments) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.setTime(time);
		this.star = star;
		this.comments = comments;
	}
	public Article(int articleId){
		this.articleId = articleId;
	}

	// Property accessors

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	



	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}