package com.example.digital.repository;

import java.time.Year;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Credential;
@Transactional
@Repository
public class CredentialDao implements ICredentialDAO {

/*	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Credential getCredentialByid(long credential_Id) {
		return entityManager.find(Credential.class, credential_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Credential> getAllCredentials() {
		String hql = "FROM Credential as cr ORDER BY cr.credential_Id DESC";
		return (List<Credential>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCredential(Credential credential) {
		entityManager.persist(credential);
	}
	
	@Override
	public void updateCredential(Credential credential) {
		
		if(credential!=null) {
		String hql="update Credential cr set cr.Credential_Name="+credential.getCredentialName()+"cr.Credential_Year"+credential.getCredentialYear()+
				"cr.Course_Id"+credential.getCourse().getCourse_Id()+"cr.Institution_Id"+credential.getInstitution().getInstitution_Id()+
				"where cr.Credential_Id="+credential.getCredential_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		}
		else {
			entityManager.remove(credential);
		}
		//entityManager.remove(getCourseByid(course_Id));
	}
	@Override
	public boolean CredentialExists(long credential_Id, String credentialName, Year credentialYear, long course_Id,
			long institution_Id) {
		String hql = "FROM Credential as cr WHERE cr.credential_id=? and cr.Credential_Name = ? and cr.Credential_Year = ? and cr.Course_Id = ? and cr.Institution_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, credential_Id).setParameter(2, credentialName)
		              .setParameter(3, credentialYear).setParameter(4, course_Id).setParameter(5, institution_Id).getResultList().size();
		return count > 0 ? true : false;  
	}
	*/

}
