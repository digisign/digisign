package com.example.digital.repository;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Institution;

@Transactional
@Repository
public class InstitutionDao implements IInstitutionDao {

/*	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Institution getInstitutionByid(long institution_Id) {
		return entityManager.find(Institution.class, institution_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Institution> getAllInstitutions() {
		String hql = "FROM Institution as ins ORDER BY ins.Institution_Id DESC";
		return (List<Institution>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addInstitution(Institution institution) {
		entityManager.persist(institution);
	}
	*//*@Override
	public void updateInstitution(Institution institution) {
		Institution ins = getInstitutionByid(institution.getInstitution_Id());
		ins.setContact(institution.getContact().getContact_Id());
		ins.setParent_Institution_Id(institution.getParent_Institution_Id());
		entityManager.flush();
	}*//*
	
	@Override
	public void updateInstitution(Institution institution) {
		String hql="update Institution ins set ins.Contact_Id="+institution.getContact().getContact_Id()+"ins.Parent_Institution_Id"+institution.getParent_Institution_Id()+
				
				"where ins.Institution_Id="+institution.getInstitution_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		
		//entityManager.remove(getInstitutionByid(Institution_Id));
	}
		public List<Institution> getContactByid(Contact contact) {
		// TODO Auto-generated method stub
		
		String hql="FROM Institution as ins WHERE ins.Contact_Id =? ";
		System.out.println("HQL->"+hql);
		return (List<Institution>) entityManager.createQuery(hql).setParameter(1, contact.getContact_Id()).getSingleResult();
	}
	public List<Institution> getParentInstitutionByid(long parent_Institution_Id) {
		// TODO Auto-generated method stub
		String hql="FROM Institution as ins WHERE ins.Parent_Institution_Id =? ";
		return  entityManager.createQuery(hql).setParameter(1, parent_Institution_Id).getResultList();
	}
	public Institution getInstitutionByName(String institutionName) {
		// TODO Auto-generated method stub
		String hql="FROM Institution as ins WHERE ins.Institution_Name =? ";
		return (Institution) entityManager.createQuery(hql).setParameter(1, institutionName).getResultList();
	}
	public boolean institutionExists(long institution_Id, long contact_id, long parent_Institution_Id,
			String institution_Name) {
		// TODO Auto-generated method stub
		String hql = "FROM Institution as ins inner join ins.Contact con WHERE ins.institution_id = ? and ins.institution_name = ? and ins.Contact_Id = ? and ins.Parent_Institution_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, institution_Id).setParameter(2, contact_id)
		              .setParameter(3, parent_Institution_Id).setParameter(4, institution_Name).getResultList().size();
		return count > 0 ? true : false;
	}*/

}
