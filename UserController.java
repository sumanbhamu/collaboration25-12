package com.suman.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suman.dao.UserDAO;
import com.suman.model.User;

@RestController
public class UserController {

	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/user")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users=userDAO.list();
		
		if(users.isEmpty())
		{
			user.setErrorCode("404");
			user.setErrorMessage("No users r available");
			// adding this msg
			users.add(user);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}

}
