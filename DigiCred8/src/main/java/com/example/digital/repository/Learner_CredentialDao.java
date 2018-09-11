package com.example.digital.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class Learner_CredentialDao implements ILearnerCredentialDao {

/*
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Learner_Credential getLearner_CredentialByid(long learner_credential_Id) {
		return entityManager.find(Learner_Credential.class, learner_credential_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Learner_Credential> getAllLearner_Credentials() {
		String hql = "FROM Learner_Credential as lc ORDER BY lc.learner_credential_Id DESC";
		return (List<Learner_Credential>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addLearner_Credential(Learner_Credential learner_credential_Id) {
		entityManager.persist(learner_credential_Id);
	}
	*/
/*@Override
	public void updateLearner_Credential(Learner_Credential learner_credential) {
		Learner_Credential lc = getLearner_CredentialByid(learner_credential.getLearner_Credential_Id());
		lc.setLearner_Id(learner_credential.getLearner_Id());
		lc.setCredential_Id(learner_credential.getCredential_Id());
		lc.setCourse_Id(learner_credential.getCourse_Id());
		lc.setGrade_Id(learner_credential.getGrade_Id());
		lc.setMarks(learner_credential.getMarks());
		lc.setIssued_date(learner_credential.getIssued_date());
		entityManager.flush();
	}*//*

	
	@Override
	public void updateLearner_Credential(Learner_Credential learner_Credential) {
		if(learner_Credential!=null) {
		String hql="update learner_Credential lc set lc.Learner_Id="+learner_Credential.getLearner().getLearnerId()+"lc.Credential_Id"+learner_Credential.getCredential().getCredential_Id()+
				"lc.Course_Id"+learner_Credential.getCourse().getCourse_Id()+"lc.Grade_Id"+learner_Credential.getGrade().getGrade_Id()+"lc.Marks"+learner_Credential.getMarks()+
				"lc.Issued_date"+learner_Credential.getIssued_date()+
				"where lc.Learner_CredentialByid="+learner_Credential.getLearner_Credential_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		}
		else {
			entityManager.remove(learner_Credential);
		}
		
		
	}
	
	@Override
	public boolean Learner_CredentialExists(Learner learner, Credential credential, Course course, Grade grade,
			String marks, Date issued_date) {
		String hql = "FROM Learner_Credential as lc WHERE lc.Learner_Id = ? and lc.Credential_Id = ? and lc.Course_Id = ?"
				+ "and lc.Grade_Id = ? and lc.Marks = ? and lc.Issued_date = ?";
		int count = entityManager.createQuery(hql).setParameter(1, learner.getLearnerId())
		              .setParameter(2, credential.getCredential_Id()).setParameter(3, course.getCourse_Id()).setParameter(4, grade.getGrade_Id()).setParameter(5, marks).
		              setParameter(6, issued_date).getResultList().size();
		return count > 0 ? true : false;
	}
*/


}
