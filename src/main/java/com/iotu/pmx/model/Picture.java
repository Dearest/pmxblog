package com.iotu.pmx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Picture entity. @author MyEclipse Persistence Tools
 */

public class Picture implements java.io.Serializable {

	// Fields

	private Integer pictureId;
	private User user;
	private String title;
	private String description;
	private String content;
	private String path;
	private Integer star;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Picture() {
	}

	/** minimal constructor */
	public Picture(User user, String title, String content, Integer star) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.star = star;
	}

	/** full constructor */
	public Picture(User user, String title, String description, String content,
			String path, Integer star, Set comments) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.content = content;
		this.path = path;
		this.star = star;
		this.comments = comments;
	}

	// Property accessors

	public Integer getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
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

}