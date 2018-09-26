package com.example.digital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.digital.entity.Contact;
import com.example.digital.entity.Course;
import com.example.digital.entity.Credential;
import com.example.digital.entity.Institution;
import com.example.digital.entity.Institution_User;
import com.example.digital.entity.Learner;
import com.example.digital.entity.Subject;
import com.example.digital.repository.ICourseDao;
import com.example.digital.repository.ICredentialDAO;
import com.example.digital.repository.ISubjectDAO;
import com.example.digital.repository.InstitutionDao;
import com.example.digital.repository.Institution_UserDao;

import javax.imageio.ImageIO;

@Service
public class InstitutionService implements IInstitutionService {

/*
	 @Autowired
	private InstitutionDao institutionDAO;
	 
	 @Autowired
	private Institution_UserDao institutionuserDao;
	 
	 @Autowired
	private ICourseDao courseDao;
	 
	 @Autowired
		private ISubjectDAO subjectDAO;
	 @Autowired
	 private ICredentialDAO iCredentialDAO;

	@Override	
	public Institution getInstitutionById(long institution_Id) {
		return institutionDAO.getInstitutionByid(institution_Id);
		
	}	
	
	
	
	@Override
    public List<Institution> getAllInstitution() {
		
		return institutionDAO.getAllInstitutions();
		
	}
	
	@Override
	public synchronized boolean addInstitution(Institution institution){
		
	
		if (institutionDAO.institutionExists(institution.getInstitution_Id(),institution.getContact().getContact_Id(),institution.getParent_Institution_Id(),institution.getInstitution_Name()))		
				 {
    	   return false;
       } else {
    	  
    	   institutionDAO.addInstitution(institution);
    	   return true;
       }
	}
	
	
	@Override
	public Institution getContactById(Contact contact) {
		Institution institution = (Institution) institutionDAO.getContactByid(contact);
		return institution;
	}
	
	@Override
	public Institution getParentInstitutionById(long Parent_Institution_Id) {
		Institution institution = (Institution) institutionDAO.getParentInstitutionByid(Parent_Institution_Id);
		return institution;
	}
	
	@Override
	public Institution getInstitutionByName(String institutionName) {
		
		Institution institution = (Institution) institutionDAO.getInstitutionByName(institutionName);
		return institution;
	}
	
	@Override
	public Institution_User getInstitution_UserById(long institution_User_Id) {
		return institutionuserDao.getInstitution_UserByid(institution_User_Id);
	}
	@Override
	public Institution_User getInstitutionUserByInstId(long institution_Id) {
		
		return institutionuserDao.getInstitutionUserByInstid(institution_Id);
		
	}

	@Override
    public Institution_User getInstitutionUserByUserId(long user_Id) {
		
		return institutionuserDao.getInstitutionUserByUserid(user_Id);
		
	}
	
	@Override
    public Institution_User getInstitutionUserByContactId(long contact_Id) {
		
		return institutionuserDao.getInstitutionUserByContactid(contact_Id);
		
	}
	
	@Override
    public Course getCourseByCourseId(long course_Id) {
		
		return courseDao.getCourseByid(course_Id);
		
	}
	
	@Override
    public List<Course> getAllCourse() {
		
		return courseDao.getAllCourses();
		
	}
	
	@Override
	public synchronized boolean addCourse(Course course){
		
	
		if (courseDao.CourseExists(course.getCourse_Id(),course.getCourse_Name(), course.getShort_Name(),course.getDescription(),course.getInstitution().getInstitution_Id(),
				
				course.getCourse_Period())) {
    	   return false;
       } else {
    	  
    	   courseDao.addCourse(course);
    	   return true;
       }
	}
	
	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}
	
	@Override
    public Subject getSubjectById(long subject_id) {
		
		return subjectDAO.getSubjectByid(subject_id);
		
	}
	
	@Override
    public List<Subject> getAllSubject() {
		
		return subjectDAO.getAllSubjects();
		
	}
	
	@Override
	public synchronized boolean addSubject(Subject subject){
		
	
		if (subjectDAO.subjectExists(subject.getSubjectId() ,subject.getSubjectName(), subject.getCourse().getCourse_Id()))
				
				 {
    	   return false;
       } else {
    	  
    	   subjectDAO.saveSubject(subject);
    	   return true;
       }
	}
	
	@Override
	public void updateSubject(Subject subject) {
		subjectDAO.updateSubject(subject);
	}

	@Override
    public Credential getCredentialById(long credential_Id) {
		
		return iCredentialDAO.getCredentialByid(credential_Id);
		
	}
	
	@Override
    public List<Credential> getAllCredential() {
		
		return iCredentialDAO.getAllCredentials();
		
	}
	
	@Override
	public synchronized boolean addCredential(Credential credential){
		
	*/
/*
		if (iCredentialDAO.CredentialExists(credential.getCredential_Id(),credential.getCredentialName(),credential.getCredentialYear(), credential.getCourse().getCourse_Id(),credential.getInstitution().getInstitution_Id()))
				 {
    	   return false;
       } else {
    	  
    	   iCredentialDAO.addCredential(credential);*//*







    	   return true;
      // }
	}
*/




	
}