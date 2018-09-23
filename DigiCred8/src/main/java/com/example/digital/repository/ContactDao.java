package com.example.digital.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digital.entity.Contact;


@Transactional
@Repository
public class ContactDao implements IContactDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//List<Contact> contacts;
	
	
	
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Contact getContactByid(long contact_Id) {
		return entityManager.find(Contact.class, contact_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {
		String hql = "FROM Contact as ct ORDER BY ct.contact_Id DESC";
		return (List<Contact>) entityManager.createQuery(hql,Contact.class).getResultList();
	}		
	@Override
	public void saveContact(Contact contact) {
		
		entityManager.persist(contact);
	}
	/*@Override
	public void updateContact(Contact contact) {
		Contact ct = getContactByid(contact.getContact_Id());
		ct.setFullName(contact.getFullName());
		ct.setFirstName(contact.getFirstName());
		ct.setLastName(contact.getLastName());
		ct.setdOB(contact.getdOB());
		ct.setMobileNumber1(contact.getMobileNumber1());
		ct.setMobileNumber2(contact.getMobileNumber2());
		ct.setEmailId1(contact.getEmailId1());
		ct.setEmailId2(contact.getEmailId2());
		
		
		
		entityManager.flush();
	}
	*/
	@Override
	public void updateContact(Contact contact) {
		
		if(contact!=null) {
		
		String hql="update Contact ct set ct.Full_Name="+contact.getFullName()+"ct.First_Name"+contact.getFirstName()+
				"ct.Last_Name"+contact.getLastName()+"ct.DOB"+contact.getdOB()+"ct.Mobile_Number_1"+contact.getMobileNumber1()+
				"ct.Mobile_Number_2"+contact.getMobileNumber2()+"ct.Email_Id_1"+contact.getEmailId1()+"ct.Email_Id_2"+contact.getEmailId2()+
				"where ct.Contact_Id="+contact.getContact_Id();
		
		System.out.println("HQL->"+hql);
		entityManager.createQuery(hql).executeUpdate();
		}
		else
		{
			
			entityManager.remove(contact);
		}
		
		
		
		
		//entityManager.remove(getContactByid(contactId));
	}
	
	
	
	@Override
	public boolean contactExists(String Full_Name, String First_Name,String Last_Name,Date DOB,String Mobile_Number_1,String Mobile_Number_2,String Email_Id_1,String Email_Id_2) {
		String hql = "FROM contact as ct WHERE ct.Full_Name = ? and ct.First_Name = ? and ct.Last_Name = ? and ct.DOB = ? and ct.Mobile_Number_1 = ? and ct.Mobile_Number_2 = ? "
				+ "and ct.Email_Id_1 = ? and ct.Email_Id_2 = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, Full_Name).setParameter(2, First_Name).setParameter(3, Last_Name).setParameter(4, DOB)
				.setParameter(5, Mobile_Number_1).setParameter(6, Mobile_Number_2).setParameter(7, Email_Id_1).setParameter(8, Email_Id_2).getResultList().size();
		return count > 0 ? true : false;
	}

}
