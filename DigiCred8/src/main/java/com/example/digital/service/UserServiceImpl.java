package com.example.digital.service;

import com.example.digital.config.CredentialEncryptionConfig;
import com.example.digital.controller.UserController;
import com.example.digital.entity.Learner;
import com.example.digital.entity.Role;
import com.example.digital.entity.User;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.RoleRepository;
import com.example.digital.repository.UserRepository;

import ch.qos.logback.classic.Logger;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.digital.common.ErrorMessages.USER_ALREADY_EXISTS;
import static com.example.digital.common.ErrorMessages.USER_NOT_AVAILABLE;
import static com.example.digital.common.ErrorMessages.WRONG_CREDENTIALS;

@Service
public class UserServiceImpl  implements UserService {
	
	public static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
	private LearnerService learnerService;

    @Override
    public User save(User user) {
		Optional<User> existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
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
			User savedUser=new User();
			if(user.getRoleId()==1){
				Learner learner=new Learner();
				learner.setUser(user);
				learner.setAadharNo(learner.getAadharNo());
				learner=learnerService.save(learner);
				savedUser=learner.getUser();
			}
			return savedUser;
		}
    }


	@Override
	public boolean  validateUser(User user) {
		Optional<User> existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
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



	@Override
	public User  getUserByEmail(String email) {
		Optional<User> existingUser = userRepository.findByEmailIgnoreCase(email);
		if(!existingUser.isPresent()){
			throw new DigiSignException(USER_NOT_AVAILABLE.getReasonPhrase(),USER_NOT_AVAILABLE.getCode());
		}
		return existingUser.get();
	}


	@Override
	public User  getUserById(Long userId) {
		Optional<User> existingUser = userRepository.findById(userId);
		if(!existingUser.isPresent()){
			throw new DigiSignException(USER_NOT_AVAILABLE.getReasonPhrase(),USER_NOT_AVAILABLE.getCode());
		}
		return existingUser.get();
	}
	
	@Override
	public User updateUser(User user) {
		Optional<User> existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
		if(!existingUser.isPresent()) {
			throw new DigiSignException(WRONG_CREDENTIALS.getReasonPhrase(),WRONG_CREDENTIALS.getCode());
		}
		else {
			String newPassword = user.getNewPassword();
			String existingHashedPassword=existingUser.get().getPassword();
			String salt=existingUser.get().getSalt();
			CredentialEncryptionConfig credentialEncryptionConfig = new CredentialEncryptionConfig();
			String generatedPaswsword=credentialEncryptionConfig.getHashedPassword(salt,existingUser.get().getEmail(),user.getPassword());
			  if(existingHashedPassword.equals(generatedPaswsword)){
				  if(user.getUserName()!=null) {
					  existingUser.get().setUserName(user.getUserName());
				  }
				  if(user.getNewEmail()!=null) {
					  Optional<User> userWithNewEmail = userRepository.findByEmailIgnoreCase(user.getNewEmail());
					  if(userWithNewEmail.isPresent()){
						  throw new DigiSignException(USER_ALREADY_EXISTS.getReasonPhrase(),USER_ALREADY_EXISTS.getCode());
					  }
					  existingUser.get().setEmail(user.getNewEmail());
				  }
				  String newSalt = Base64.getEncoder().encodeToString(CredentialEncryptionConfig.getNextSalt());
					String hashedPassword = credentialEncryptionConfig.getHashedPassword(newSalt,existingUser.get().getEmail(),newPassword);
					existingUser.get().setPassword(hashedPassword);
					existingUser.get().setSalt(newSalt);
					existingUser.get().setUpdatedDate(new Date());
					Boolean islearner=existingUser.get().getRoles().stream().map(Role::getRoleId).anyMatch(roleId->roleId==1);
					if(islearner){
						Learner learner=learnerService.getLearnerByUser(existingUser.get());
						learner.setAadharNo(user.getAadharNo());
						learner.setUser(existingUser.get());
						learner=learnerService.save(learner);
						return learner.getUser();
					}else {
						return userRepository.save(existingUser.get());
					}
					
				  
				} else{
					throw new DigiSignException(WRONG_CREDENTIALS.getReasonPhrase(),WRONG_CREDENTIALS.getCode());
				}
					}
		
		
	}

	@Override
	public void  softdeleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(user);
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

