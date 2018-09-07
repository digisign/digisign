package com.example.digital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.digital.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmail(String email);

/*	List<User> getUserById(long userId);

	List<User> getAllUsers();

	User findById(long userId);

	boolean userExists(String username, String password);

	User save(User user);

	void deleteUser(User user);

	void updateUser(User user);*/

}
