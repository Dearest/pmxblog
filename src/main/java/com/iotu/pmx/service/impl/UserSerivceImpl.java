package com.iotu.pmx.service.impl;

import com.iotu.pmx.dao.IUserDao;
import com.iotu.pmx.model.User;
import com.iotu.pmx.service.IUserService;
import com.iotu.pmx.util.SHA256Util;

public class UserSerivceImpl implements IUserService{
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public User login(User user) throws Exception {
		User queryUser = userDao.findUserByName(user);
		
		if (queryUser != null) {
			if (queryUser.getPassword().equals(SHA256Util.hash(user.getPassword()+queryUser.getSalt()))) {
				return queryUser;
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	
}
