package com.iotu.pmx.service;

import com.iotu.pmx.model.User;

public interface IUserService {
	
	public User login(User user) throws Exception;
}
