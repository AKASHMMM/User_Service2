package com.example.Service;

import java.util.List;

import com.example.Entity.User;
import com.example.Exceptions.UserAlreadyExistsException;
import com.example.Exceptions.UserNotFoundException;

public interface UserService {
	
	public User addUser(User user)throws UserAlreadyExistsException;
	public String deleteUser(int userid) throws UserNotFoundException;
	public User updateUser(User user, int userid) throws UserNotFoundException;
	public User getUserByid(int userid) throws UserNotFoundException;
	public User getUserByEmail(String email)throws UserNotFoundException;
	List<User> getAllUsers();

}
