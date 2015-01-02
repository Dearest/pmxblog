package com.iotu.pmx.dao;

import com.iotu.pmx.model.User;

public interface IUserDao {
	
	public User findUserByName(User user) throws Exception;
	
}
