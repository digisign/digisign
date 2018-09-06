package com.example.digital.repository;


import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Learner;
import com.example.digital.entity.User;

@Repository
@Qualifier("LearnerDao")
public class LearnerDao implements ILearnerDao {
	
	//private static Map<Integer,Learner> learners;


	@Autowired
	@PersistenceContext	
	@Qualifier(value = "entityManager")
	private EntityManager entityManager;
	
	
	@Override
	public Learner getLearnerByid(long Learner_id) {
		return  entityManager.find(Learner.class, Learner_id);
	}
	@Override
	public Learner getContactByid(Contact contact) {
		return entityManager.find(Learner.class, contact.getContact_Id());
	}
	@Override
	public Learner getUserByid(User user) {
		return entityManager.find(Learner.class, user.getUserId());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Learner> getAllLearners() {
		String hql = "FROM Learner as lr inner join User us on lr.userId=us.userId inner join Contact co on lr.Contact_Id=co.Contact_Id where lr.Learner_id DESC";
		return (List<Learner>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addLearner(Learner learner) {
		learner.setLearnerId(learner.getLearnerId());
		learner.setUser(learner.getUser());
		learner.setContact(learner.getContact());
		entityManager.persist(learner);
	}
	
	@Override
	public boolean learnerExists(long learner_id, User user,Contact contact ) {
		String hql = "FROM learner as lr WHERE lr.learner_id = ? and user.user_id = ? and contact.contact_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, learner_id).setParameter(2, contact.getContact_Id() ).setParameter(3, user.getUserId()).getResultList().size();
		return count > 0 ? true : false;
	}
	
	
	
	
	
}
