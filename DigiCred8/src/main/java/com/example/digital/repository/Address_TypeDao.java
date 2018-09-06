package com.example.digital.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.digital.entity.Address_Type;



public class Address_TypeDao implements IAddress_TypeDao {

	private EntityManager entityManager;
	
	@Override
	public Address_Type getAddress_Type(int Address_Type) {
		return entityManager.find(Address_Type.class, Address_Type);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Address_Type> getAllAddress_Type() {
		String hql = "FROM Address_Type as ae ORDER BY ae.Address_Type DESC";
		return (List<Address_Type>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public boolean Address_TypeExists(String Address_Type_Desc) {
		String hql = "FROM Address_Type as ae WHERE ae.Address_Type_Desc = ?";
		int count = entityManager.createQuery(hql).setParameter(1, Address_Type_Desc).getResultList().size();
		return count > 0 ? true : false;
	}

	

}
