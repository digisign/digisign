package com.example.digital.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Address_Type;
import com.example.digital.entity.Contact;
import com.example.digital.entity.Contact_Address;

@Transactional
@Repository
public class Contact_AddressDao implements IContactAddressDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Contact_Address getContact_AddressByid(long Address_Id) {
		return entityManager.find(Contact_Address.class, Address_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact_Address> getAllContact_Address() {
		String hql = "FROM Contact_Address as ca ORDER BY ca.Address_Id DESC";
		return (List<Contact_Address>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void saveContact_Address(Contact_Address contact_address) {
		entityManager.persist(contact_address);
	}
	/*@Override
	public void updateContact_Address(Contact_Address contact_address) {
		Contact_Address ca = getContact_AddressByid(contact_address.getAddress_Id());
		ca.setContact(contact_address.getContact());
		ca.setAddress_Type(contact_address.getAddress_Type());
		ca.setAddress_1(contact_address.getAddress_1());
		ca.setAddress_2(contact_address.getAddress_2());
		ca.setAddress_3(contact_address.getAddress_3());
		ca.setCity(contact_address.getCity());
		ca.setState(contact_address.getState());
		ca.setCountry(contact_address.getCountry());
		ca.setPostal_Code(contact_address.getPostal_Code());
		entityManager.flush();
	}*/
	
	@Override
	public void updateContact_Address(Contact_Address contact_address) {
		
		if(contact_address!=null) {
		String hql="update Contact_Address ca set ca.Contact_Id="+contact_address.getContact()+"ca.Address_Type"+contact_address.getAddress_Type()+
				"ca.Address_1="+contact_address.getAddress_1()+"ca.Address_2"+contact_address.getAddress_2()+
				"ca.Address_3"+contact_address.getAddress_3()+"ca.City"+contact_address.getCity()+"ca.State"+contact_address.getState()+
				"ca.Country"+contact_address.getCountry()+"ca.Postal_Code"+contact_address.getPostal_Code()+
				"where ca.Address_Id="+contact_address.getAddress_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		
		
		}
		
		else {
			entityManager.remove(contact_address);
		}
		//entityManager.remove(getContact_AddressByid(Address_Id));
	}
	/*@Override
	public boolean Contact_AddressExists( long Contact_Id,String Address_Type,String Address_1,String Address_2,String Address_3,
			String City,String State,String Country,long Postal_Code) {
		String hql = "FROM Contact_Address as ca WHERE ct.Contact_Id = ? and ct.Address_Type = ? and ct.Address_1 = ? "
				+ "and ct.Address_2 = ? and ct.Address_3 = ? "+ "and ct.City = ? and ct.State = ?  and ct.Country = ? and ct.Postal_Code = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, Contact_Id).setParameter(2, Address_Type).setParameter(3, Address_1)
				.setParameter(4, Address_2).setParameter(5, Address_3).setParameter(6, City).setParameter(7, State).setParameter(8, Country).setParameter(9, Postal_Code).getResultList().size();
		return count > 0 ? true : false;
	}*/
	@Override
	public boolean Contact_AddressExists(Contact contact, Address_Type address_Type, String Address_1, String Address_2,
			String Address_3, String City, String State, String Country, long Postal_Code) {
		// TODO Auto-generated method stub
		String hql = "FROM Contact_Address as ca WHERE ct.Contact_Id = ? and ct.Address_Type = ? and ct.Address_1 = ? "
				+ "and ct.Address_2 = ? and ct.Address_3 = ? "+ "and ct.City = ? and ct.State = ?  and ct.Country = ? and ct.Postal_Code = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, contact.getContact_Id()).setParameter(2, address_Type.getAddress_Type()).setParameter(3, Address_1)
				.setParameter(4, Address_2).setParameter(5, Address_3).setParameter(6, City).setParameter(7, State).setParameter(8, Country).setParameter(9, Postal_Code).getResultList().size();
		return count > 0 ? true : false;
	}
	
	
	
	


}
