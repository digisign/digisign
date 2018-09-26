package com.example.digital.repository;

import com.example.digital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmailIgnoreCase(String email);

	Optional<User> findByUserId(Long userId);

/*	List<User> getUserById(long userId);

	List<User> getAllUsers();

	User findById(long userId);

	boolean userExists(String username, String password);

	User save(User user);

	void deleteUser(User user);

	void updateUser(User user);*/

}
