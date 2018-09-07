package com.example.digital.service;
import java.util.*;

import com.example.digital.config.CredentialEncryptionConfig;
import com.example.digital.entity.Role;
import com.example.digital.exception.DigiSignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.User;
import com.example.digital.repository.RoleRepository;
import com.example.digital.repository.UserRepository;

import static com.example.digital.common.ErrorMessages.USER_ALREADY_EXISTS;
import static com.example.digital.common.ErrorMessages.WRONG_CREDENTIALS;

@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isPresent()){
			throw new DigiSignException(USER_ALREADY_EXISTS.getReasonPhrase(),USER_ALREADY_EXISTS.getCode());
		}
		else {
			CredentialEncryptionConfig credentialEncryptionConfig = new CredentialEncryptionConfig();
			String salt = Base64.getEncoder().encodeToString(CredentialEncryptionConfig.getNextSalt());
			String hashedPassword = credentialEncryptionConfig.getHashedPassword(salt,user.getEmail(),user.getPassword());
			user.setPassword(hashedPassword);
			Role role=roleRepository.findById(user.getRoleId()).get();
			Set<Role> roleSet=new HashSet();
			roleSet.add(role);
			user.setSalt(salt);
			user.setRoles(roleSet);
			user.setActive(true);
			user.setCreatedDate(new Date());
			user.setUpdatedDate(new Date());
			return  userRepository.save(user);
		}
    }


	@Override
	public boolean  validateUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(!existingUser.isPresent()){
			throw new DigiSignException(WRONG_CREDENTIALS.getReasonPhrase(),WRONG_CREDENTIALS.getCode());
		}
		else {
			String correctPassword=existingUser.get().getPassword();
			String salt=existingUser.get().getSalt();
			CredentialEncryptionConfig credentialEncryptionConfig = new CredentialEncryptionConfig();
			String generatedPaswsword=credentialEncryptionConfig.getHashedPassword(salt,existingUser.get().getEmail(),user.getPassword());
		    if(correctPassword.equals(generatedPaswsword)){
		    	return true;
			} else{
				throw new DigiSignException(WRONG_CREDENTIALS.getReasonPhrase(),WRONG_CREDENTIALS.getCode());
			}
		}
	}




/*    @Override
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
	}*/
}

