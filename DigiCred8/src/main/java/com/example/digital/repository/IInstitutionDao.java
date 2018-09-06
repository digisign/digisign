package com.example.digital.repository;


import java.util.List;
import java.util.Optional;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Institution;


public interface IInstitutionDao {

	List<Institution> getAllInstitutions();
	Institution getInstitutionByid(long institution_Id);
    void addInstitution(Institution institution);
    void updateInstitution(Institution institution);
   // void deleteInstitution(Institution institution);
    public boolean institutionExists(long institution_Id, long contact_id, long parent_Institution_Id,
			String institution_Name);
}
