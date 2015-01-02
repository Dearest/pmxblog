package com.iotu.pmx.service.impl;

import com.iotu.pmx.dao.ICommentDao;
import com.iotu.pmx.model.Comment;
import com.iotu.pmx.service.ICommentService;



public class CommentServiceImpl implements ICommentService{
	private ICommentDao commentDao;


	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}


	public Comment saveComment(Comment comment) throws Exception {
		
		return commentDao.saveComment(comment);
	}
}
