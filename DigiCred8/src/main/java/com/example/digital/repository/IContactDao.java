package com.example.digital.repository;

import java.sql.Date;
import java.util.List;

import com.example.digital.entity.Contact;


public interface IContactDao {
	List<Contact> getAllContacts();
	Contact getContactByid(long contact_Id);
    void updateContact(Contact contact);
    //void deleteContact(Contact contact);
    boolean contactExists(String Full_Name, String First_Name,String Last_Name,Date DOB,String Mobile_Number_1,String Mobile_Number_2,
    		String Email_Id_1,String Email_Id_2);
	void saveContact(Contact contact);
	
 
}
