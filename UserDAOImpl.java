package com.suman.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suman.model.User;
@Repository(value = "UserDAO")
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;

	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User get(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
