package com.iotu.pmx.dao.impl;

import org.hibernate.SessionFactory;

import com.iotu.pmx.dao.ICommentDao;
import com.iotu.pmx.model.Comment;



public class CommentDaoImpl implements ICommentDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Comment saveComment(Comment comment) throws Exception {
		sessionFactory.getCurrentSession().save(comment);
		return comment;
	}
}
