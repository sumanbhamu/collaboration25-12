package com.suman.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suman.model.Event;

@Repository(value = "BlogDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean save(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	public Event get(int eventID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
