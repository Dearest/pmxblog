package com.iotu.pmx.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Article article;
	private Picture picture;
	private String fromUser;
	private String toUser;
	private String content;
	private Date time;
	private Integer isRecomment;
	private Integer recommentId;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(String fromUser, String toUser, String content,
			Timestamp time, Integer isRecomment) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.setTime(time);
		this.isRecomment = isRecomment;
	}

	/** full constructor */
	public Comment(Article article, Picture picture, String fromUser,
			String toUser, String content, Timestamp time, Integer isRecomment,
			Integer recommentId) {
		this.article = article;
		this.picture = picture;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.setTime(time);
		this.isRecomment = isRecomment;
		this.recommentId = recommentId;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return this.toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public Integer getIsRecomment() {
		return this.isRecomment;
	}

	public void setIsRecomment(Integer isRecomment) {
		this.isRecomment = isRecomment;
	}

	public Integer getRecommentId() {
		return this.recommentId;
	}

	public void setRecommentId(Integer recommentId) {
		this.recommentId = recommentId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}