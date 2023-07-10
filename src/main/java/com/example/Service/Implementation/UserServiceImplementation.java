package com.example.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Exceptions.UserAlreadyExistsException;
import com.example.Exceptions.UserNotFoundException;
import com.example.Repository.UserRespository;
import com.example.Service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRespository userrepo;

	@Override
	public User addUser(User user) {
		User user1 = userrepo.findById(user.getUserId()).orElse(null);
		if (user1 == null) {
			return userrepo.save(user);
			
		} else {
			throw new UserAlreadyExistsException("User Alreay Exists");
			
		}
	}

	@Override
	public String deleteUser(int userid) throws UserNotFoundException {
		Optional<User> useropt = userrepo.findById(userid);
		if (useropt.isPresent()) {
			User c = useropt.get();
			userrepo.deleteById(userid);
			return "User Deleted Succesfully!";
		} else {
			throw new UserNotFoundException("User not found");
		}

	}

	@Override
	public User updateUser(User user, int userid) throws UserNotFoundException {
		Optional<User> useropt = userrepo.findById(userid);
		if (useropt.isPresent()) {
			User c1 = useropt.get();

			c1.setEmail(user.getEmail());
			c1.setMobileNumber(user.getMobileNumber());
			c1.setPassword(user.getPassword());
			c1.setUserName(user.getUserName());
			userrepo.save(c1);
			return c1;
		} else {
			throw new UserNotFoundException("User not found");
		}

	}

	@Override
	public User getUserByid(int userid) {
		User user2 = userrepo.findById(userid).orElse(null);
		if(user2==null) {
			throw new UserNotFoundException("User not found");
		}else {
			return user2;
		}
	}
	
	@Override
	public User getUserByEmail(String email)throws UserNotFoundException{
		User u=userrepo.findByEmail(email);
		if(u==null) {
			throw new UserNotFoundException("User not found with this email");
		}
		else {
			return u;
		}
	}
	
	@Override

	public List<User> getAllUsers() {

	return (List<User>) userrepo.findAll();

	}

}










