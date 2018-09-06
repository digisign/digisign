package com.example.digital.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.digital.entity.User;

@Repository

public interface UserRepository {

	User findByUserName(String userName);

	List<User> getUserById(long userId);

	List<User> getAllUsers();

	User findById(long userId);
	

	//void updateUser(User user);

	//void deleteUser(long userId);

	boolean userExists(String username, String password);

	void save(User user);

	void addUser(User user);

	void deleteUser(User user);

	void updateUser(User user);

	

	
}
