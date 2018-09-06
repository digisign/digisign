package com.example.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Contact_Address;
import com.example.digital.entity.Course;
import com.example.digital.entity.Learner;
import com.example.digital.entity.Learner_Credential;
import com.example.digital.entity.Learner_Credential_Resourse;
import com.example.digital.entity.Subject;
import com.example.digital.entity.User;
import com.example.digital.repository.IContactAddressDao;
import com.example.digital.repository.IContactDao;
import com.example.digital.repository.ICourseDao;
import com.example.digital.repository.ILearnerCredentialDao;
import com.example.digital.repository.ILearnerDao;
import com.example.digital.repository.ILearner_Credential_ResourseDao;
import com.example.digital.repository.ISubjectDAO;
import com.example.digital.repository.ISubjectMarksDAO;




@Service
public class LearnerService  implements ILearnerService{

	@Autowired
	private ILearnerDao learnerDAO;
	
	@Autowired
	private	IContactAddressDao contactaddressDAO;
	@Autowired
	private	IContactDao contactDAO;
	@Autowired
	private ILearnerCredentialDao learnercredentialDAO;
	/*@Autowired
	private	ILearner_Credential_ResourseDao learnercredentialresourceDAO;
	@Autowired
	private ICourseDao courseDAO;
	@Autowired
	private ISubjectDAO subjectDAO;
	@Autowired
	private ISubjectMarksDAO subjectmarksDAO;
	*/
	 
	@Override	
	public Learner getLearnerById(long learner_id) {
		return learnerDAO.getLearnerByid(learner_id);
		
	}	
	@Override
	public Learner getUserById(User user) {
		Learner learner = learnerDAO.getUserByid(user);
		return learner;
	}
	@Override
	public Contact getContactById(long contact_Id) {
		Contact contact = contactDAO.getContactByid(contact_Id);
		return contact;
	}
	
	@Override
	public Contact_Address getContact_AddressById(long Address_Id) {
		Contact_Address address = contactaddressDAO.getContact_AddressByid(Address_Id);
		return address;
	}
	@Override
	public Learner_Credential getLearner_CredentialById(long Learner_Credential_Id) {
		Learner_Credential learnerCredential=learnercredentialDAO.getLearner_CredentialByid(Learner_Credential_Id);
		return learnerCredential;
		
	}
	/*@Override
	public Learner_Credential_Resourse getResourceById(long Resourse_Id) {
		Learner_Credential_Resourse learnerCredentialresource=learnercredentialresourceDAO.findByresourseId(Resourse_Id);
		return learnerCredentialresource;
		
	}
	@Override
	public Course getCourseById(long course_Id) {
		Course course = courseDAO.getCourseByid(course_Id);
		return course;
	}
	
	@Override
	public Subject getSubjectById(long subjectId) {
		Subject subject = subjectDAO.getSubjectByid(subjectId);
		return subject;
	}*/
	@Override
	public List<Learner> getAllLearners(){
		return learnerDAO.getAllLearners();
	}
	
	/*@Override
	public Learner getContactByid(Contact contact) {
		Learner learner = learnerDAO.getContactByid(contact);
		return learner;
	}*/
	
	
	
	@Override
	public List<Contact> getAllContacts(){
		return contactDAO.getAllContacts();
	}
	@Override
	public List<Contact_Address> getAllContact_Address(){
		return contactaddressDAO.getAllContact_Address();
	}
	@Override
	public List<Learner_Credential> getAllLearner_Credentials() {
		
		return learnercredentialDAO.getAllLearner_Credentials();
	}
	/*
	call by learner and institution
	*/
	@Override
	public synchronized boolean addLearner(Learner learner){
		
	
		if (learnerDAO.learnerExists(learner.getLearnerId(),learner.getUser(), learner.getContact())) {
    	   return false;
       } else {
    	  
    	   learnerDAO.addLearner(learner);
    	   return true;
       }
	}
	

	@Override
	public synchronized boolean addContact(Contact contact){
       if (contactDAO.contactExists(contact.getFullName(), contact.getFirstName(),contact.getLastName(),
    		   contact.getdOB(),contact.getEmailId1(),contact.getEmailId2(),contact.getMobileNumber1(),contact.getMobileNumber2())) {
    	   return false;
       } else {
    	   contactDAO.saveContact(contact);
    	   return true;
       }
	}
	
	@Override
	public synchronized boolean addContact_Address(Contact_Address contact_address){
       if (contactaddressDAO.Contact_AddressExists(contact_address.getContact(), contact_address.getAddress_Type(),contact_address.getAddress_1(),
    		   contact_address.getAddress_2(),contact_address.getAddress_3(),contact_address.getCity(),contact_address.getState(),contact_address.getCountry(),contact_address.getPostal_Code())) {
    	   return false;
       } else {
    	   contactaddressDAO.saveContact_Address(contact_address);
    	   return true;
       }
	}
	/*@Override
	public void updateLearner(Learner learner) {
		learnerDAO.updateLearner(learner);
	}*/
	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}
	@Override
	public void updateContact_Address(Contact_Address contact_address) {
		contactaddressDAO.updateContact_Address(contact_address);
	}
	
	/*@Override
	public void deleteLearner(long Learner_id) {
		learnerDAO.deleteLearner(Learner_id);
	}*/
	/*@Override
	public void softdeleteContact(Contact contact) {
		contactDAO.deleteContact(contact);
	}
	@Override
	public void softdeleteContact_Address(Contact_Address contact_address) {
		contactaddressDAO.deleteContact_Address(contact_address);
	}
	
	*/
	@Override
	public void updateLearner_Credential(Learner_Credential learner_credential) {
		learnercredentialDAO.updateLearner_Credential(learner_credential);
	}
	@Override
	public void softdeleteContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void softdeleteContact_Address(Contact_Address contact_address) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteLearner_Credential(Learner_Credential learner_credential) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void deleteLearner_Credential(Learner_Credential learner_credential) {
		learnercredentialDAO.deleteLearner_Credential(learner_credential);
	}
*/

	
	
	
	////////////////////
	/*
	@Override
	public void uploadLearner_Credential_Resource(long Resourse_Id) {
		learnercredentialresourceDAO.
	}
	
	@Override
	public void downloadLearner_Credential_Resource(long Resourse_Id) {
		// TODO Auto-generated method stub
		learnercredentialresourceDAO.
	}
	@Override
	public void deleteLearner_Credential_Resource(long Resourse_Id) {
		// TODO Auto-generated method stub
		learnercredentialresourceDAO.
	}
	@Override
	public void shareLearner_Credential_Resource(long Resourse_Id) {
		// TODO Auto-generated method stub
		
	}*/

	
}
