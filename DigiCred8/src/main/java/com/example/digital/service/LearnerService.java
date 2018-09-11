package com.example.digital.service;

import com.example.digital.entity.Learner;


public interface LearnerService {

	/*List<Learner> getAllLearners();
	List<Contact> getAllContacts();
	List<Contact_Address> getAllContact_Address();
	List<Learner_Credential> getAllLearner_Credentials();
	Learner getLearnerById(long learnerId);
	Contact getContactById(long contact_Id);
    boolean addLearner(Learner learner);
   *//* void updateLearner(Learner learner);
    void deleteLearner(long learnerId);*//*
    boolean addContact(Contact contact);
    void updateContact(Contact contact);
    Contact_Address getContact_AddressById(long Address_Id);
    boolean addContact_Address(Contact_Address contact_address);
    void updateContact_Address(Contact_Address contact_address);
	void updateLearner_Credential(Learner_Credential learner_credential);
	//void deleteLearner_Credential(long learner_credential_Id);
	*//*void uploadLearner_Credential_Resource(long Resourse_Id);
	void downloadLearner_Credential_Resource(long Resourse_Id);
	void shareLearner_Credential_Resource(long Resourse_Id);*//*
	Learner getUserById(User user);
	//Learner getContactByid(Contact contact);
	void softdeleteContact(Contact contact);
	void softdeleteContact_Address(Contact_Address contact_address);
	void deleteLearner_Credential(Learner_Credential learner_credential);
	Learner_Credential getLearner_CredentialById(long Learner_Credential_Id);
	*//*Subject getSubjectById(long subjectId);
	Course getCourseById(long course_Id);
	Learner_Credential_Resourse getResourceById(long Resourse_Id);
	*//*
	*/

	Learner save(Learner learner);
	
}
