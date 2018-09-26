package com.example.digital.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Institution_User;

@Transactional
@Repository
public class Institution_UserDao implements IInstitutionUserDao {

	/*@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Institution_User getInstitution_UserByid(long institution_User_Id) {
		return entityManager.find(Institution_User.class, institution_User_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Institution_User> getAllInstitution_Users() {
		String hql = "FROM Institution_User as inu ORDER BY inu.institution_User_Id DESC";
		return (List<Institution_User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createInstitution_User(Institution_User institution_User) {
		entityManager.persist(institution_User);
	}
	@Override
	public void updateInstitution_User(Institution_User institution_User) {
		Institution_User inu = getInstitution_UserByid(institution_User.getInstitution_User_Id());	
		
		entityManager.flush();
	}
	
	@Override
	public void deleteInstitution_User(long institution_UserByid) {
		entityManager.remove(getInstitution_UserByid(institution_UserByid));
	}
	@Override
	public boolean institution_UserExists(long Institution_Id, long User_Id,long Contact_Id) {
		String hql = "FROM Institution_User as inu WHERE inu.Institution_Id = ? and inu.User_Id = ? and inu.Contact_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, Institution_Id)
		              .setParameter(2, User_Id).setParameter(3, Contact_Id).getResultList().size();
		return count > 0 ? true : false;
	}
	public Institution_User getInstitutionUserByInstid(long institution_Id) {
		// TODO Auto-generated method stub
		String hql="FROM Institution_User as inu WHERE inu.Institution_Id =? ";
		return  (Institution_User) entityManager.createQuery(hql).setParameter(1, institution_Id).getResultList();
	}
	public Institution_User getInstitutionUserByUserid(long user_Id) {
		// TODO Auto-generated method stub
		String hql="FROM Institution_User as inu WHERE inu.user_id =? ";
		return  (Institution_User) entityManager.createQuery(hql).setParameter(1, user_Id).getResultList();
	}
	
	public Institution_User getInstitutionUserByContactid(long contact_Id) {
		// TODO Auto-generated method stub
		String hql="FROM Institution_User as inu WHERE inu.user_id =? ";
		return  (Institution_User) entityManager.createQuery(hql).setParameter(1, contact_Id).getResultList();
	}
	*/
	

	

}
