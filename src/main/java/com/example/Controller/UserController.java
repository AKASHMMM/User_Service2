package com.example.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Service.Implementation.UserServiceImplementation;



@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@EnableEurekaClient
public class UserController {
	@Autowired
	UserServiceImplementation userservice;
	
	private static Logger logger = LogManager.getLogger();

	@PostMapping("/addUser")
	ResponseEntity<User> addUser(@RequestBody User user) {
		logger.info("Sending request to add user");
		User p1 = userservice.addUser(user);
		logger.info("user added");
		return new ResponseEntity<>(p1, HttpStatus.CREATED);

	}

	@GetMapping("/getUserByid/{userid}")
	ResponseEntity<User> getuser(@PathVariable int userid) {
		logger.info("request sent to get user by id");
		User p1 = userservice.getUserByid(userid);
		logger.info("user details received");
		return new ResponseEntity<>(p1, HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteUser/{userid}")

	ResponseEntity<String> deleteUser(@PathVariable int userid) {
		logger.info("sent request to delete user");
		String p1 = userservice.deleteUser(userid);
		logger.info("user deleted");
		return new ResponseEntity<>(p1, HttpStatus.CREATED);

	}

	@PutMapping("/updateUser/{userid}")
	ResponseEntity<User> updateUser(@PathVariable int userid, @RequestBody User  user) {
		logger.info("sent request to update user");
		
		User c1 = userservice.updateUser(user, userid);
		logger.info("user updated");
		return new ResponseEntity<>(c1, HttpStatus.CREATED);

	}
	
	@GetMapping("/getUserByEmail/{email}")
	ResponseEntity<User> getuser(@PathVariable String email) {
		logger.info("request sent to get user by email");
		User p1 = userservice.getUserByEmail(email);
		logger.info("user details received");
		return new ResponseEntity<>(p1, HttpStatus.CREATED);

	}
	
	@GetMapping("/getallUsers")
	public ResponseEntity<List<User>> getAllUsers(){
	logger.info("Sending request to get all Users");
	List<User> i1 = userservice.getAllUsers();
	logger.info("All Users are displayed");
	return new ResponseEntity<>(i1,HttpStatus.OK);
	}

}
