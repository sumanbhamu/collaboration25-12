package com.suman.dao;

import java.util.List;

import com.suman.model.Friend;

public interface FriendDAO {

	
public boolean save(Friend friend); 
	
	public boolean update(Friend friend);
	
	public boolean delete(String userID,String friendID);
	
	public List<Friend> getMyFriends(String userID);
	
	public Friend getName(String name);
	
	
}
