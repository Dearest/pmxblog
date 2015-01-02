package com.iotu.pmx.dao.impl;

import org.hibernate.SessionFactory;

import com.iotu.pmx.dao.IUserDao;
import com.iotu.pmx.model.User;

public class UserDaoImpl implements IUserDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public User findUserByName(User user) throws Exception {
		String hql = "FROM User u WHERE u.name = :name";
		
		return (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name",user.getName()).uniqueResult();
	}
	

}
