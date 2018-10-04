package com.example.digital.service;

import java.util.List;

import com.example.digital.entity.User;

public interface UserService {

    User save(User user);
    boolean  validateUser(User user);
    

    User  getUserByEmail(String email);


    User  getUserById(Long userId);
	User updateUser(User user);
	

	//User findByEmail(String email);

/*	List<User> getUsersById(long parseInt);

	List<User> getAllUsers();

	void updateUser(User user);

	//void deleteUser(long parseInt);

	User findByID(long userid);

	void softdeleteUser(User user);*/

	//void updateUser(long id, String username, String password, boolean enable);



}
