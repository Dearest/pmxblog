package com.iotu.pmx.dao;

import com.iotu.pmx.model.Comment;



public interface ICommentDao {
	
	/**
	 * 保存评论
	 * @param comment
	 * @return  保存进数据库里的comment对象
	 * @throws Exception
	 */
	public Comment saveComment(Comment comment) throws Exception;
}
