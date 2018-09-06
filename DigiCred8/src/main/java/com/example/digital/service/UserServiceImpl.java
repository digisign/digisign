package com.example.digital.service;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.User;
import com.example.digital.repository.RoleRepository;
import com.example.digital.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    //@Autowired
   // private UserRepository userRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
      
    
    @Override
    public synchronized boolean save(User user) {
    	if(userRepository.userExists(user.getUsername(), user.getPassword())) {
    		return false;
    	}
    	else {
    	
    		 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	        user.setRoles(new HashSet<>(roleRepository.findAllRoles()));
    	        
        userRepository.save(user);
        return true;
    }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

	@Override
	public List<User> getUsersById(long userId) {
		// TODO Auto-generated method stub
		return  userRepository.getUserById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
		
	}

	@Override
	public void  softdeleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(user);
	}

	@Override
	public User findByID(long userid) {
		// TODO Auto-generated method stub
		return null;
	}
}

