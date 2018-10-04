package com.example.digital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.digital.entity.User;
import com.example.digital.entity.UserState;
@Repository
public class UserDao  {
	
	
	
/*
	@PersistenceContext
	private EntityManager entityManager;
	
	*/
/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*//*

    
	
	@Override
	public List<User> getUserById(long userId) {
		String hql = "FROM User as atcl where atcl.userId= ?";
		return (List<User>) entityManager.createQuery(hql).setParameter(0, userId).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as atcl ORDER BY atcl.userId DESC";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	

	@Override
	@Transactional
	public void save(User user) {
		*/
/*user.setUsername(user.getEmailId());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      //user.setRoles(new HashSet<>(roleRepository.findAll()));
*//*
		entityManager.persist(user);
	}
	
	@Override
	public void updateUser(User user) {
		String hql="update User u set u.username="+user.getUsername()+",u.password="+user.getPassword()+",u.enable="+user.getEnable()+" where u.user_id="+user.getUserId();
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
	}
	
	public User findById(long userId) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, userId);
	}

	@PreRemove
	@Override
	public void deleteUser(User user) {
		//log.info("Set state to be DELETED");
		//user.setEnable(user.getEnable());
		//String hql = "user as u set u.enable=FALSE where u.user_id=? ";
		String hql="update User u set u.enable='FALSE' where u.userId="+user.getUserId();
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		//update Student s set e=s.marks=50 where s.studentId=?;
	//entityManager.remove(user);
	}
	
	@Override
	public boolean userExists(String username, String password) {
		String hql = "FROM User as atcl WHERE atcl.username = ? and atcl.password = ?";
		int count = entityManager.createQuery(hql).setParameter(0, username)
		              .setParameter(1, password).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}
*/



	
}
