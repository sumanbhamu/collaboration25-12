package com.suman.restController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suman.dao.UserDAO;
import com.suman.model.User;

@RestController
public class UserController {

	@Autowired
	HttpSession httpSession;
	
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	/* http://localhost:8088/cobackend/userL----userList  */
	@RequestMapping("/userL")
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

	/* http://localhost:8088/cobackend/userL/uid---to get particular user  */
	
	@RequestMapping("/userL/{uid}")
	public ResponseEntity<User> getByUserId(@PathVariable("uid")String userId)
	{
		user=userDAO.get(userId);
		if(user==null)
		{
			user=new User();//to avoid NLP-EX
			user.setErrorCode("404");
			user.setErrorMessage("User does not exist with id "+userId);
			
		}
		user.setErrorCode("200");
		user.setErrorMessage("User exists with id "+userId);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}



	
	/* http://localhost:8088/cobackend/userL/uid/password---authenticate user  */
	@RequestMapping(value="/authenticate/",method=RequestMethod.POST)
	public ResponseEntity<User> autheticate(@RequestBody User user)
	{
		user=userDAO.isValidUser(user.getUserid(),user.getPassword());
		if(user==null)  //if the credentials r wrong
		{
			user=new User();  //to avoid NLP-EX
			user.setErrorCode("404");
			user.setErrorMessage("invalid credentials.. pls try again!!");
			
		}
		else   //valid credentials
		{
			
			user.setErrorCode("200");
			user.setErrorMessage("successfully logged in...");
			//store the id in session
			httpSession.setAttribute("loggedInUserId",user.getUserid());
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	
	/* register*/
	@RequestMapping(value="/register/",method=RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		if(userDAO.get(user.getUserid())!=null){
			user.setErrorCode("404");
			user.setErrorMessage("User already exists with the id :"+user.getUserid());
			
		}
		else{
			userDAO.save(user);
			user.setErrorCode("200");
			user.setErrorMessage("Thakyou for the registration....");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}


	
	/*Update*/
	@RequestMapping(value="/update/",method=RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user)
	{
		if(userDAO.get(user.getUserid())==null){
			user.setErrorCode("404");
			user.setErrorMessage("Update is not successfull..pls try after some time...");
			
		}else{
			userDAO.update(user);
			user.setErrorCode("200");
			user.setErrorMessage("Successfully updated......");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
