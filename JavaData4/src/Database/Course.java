package Database;

import java.sql.Date;

public class Course {

	private Integer Course_Id;
    private String Course_Name;
    private String Short_Name;
    private String Description;
    private  Integer Institution_Id;
    private String Course_Period;
	public Integer getCourse_Id() {
		return Course_Id;
	}
	public void setCourse_Id(Integer course_Id) {
		Course_Id = course_Id;
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}
	public String getShort_Name() {
		return Short_Name;
	}
	public void setShort_Name(String short_Name) {
		Short_Name = short_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getInstitution_Id() {
		return Institution_Id;
	}
	public void setInstitution_Id(Integer institution_Id) {
		Institution_Id = institution_Id;
	}
	public String getCourse_Period() {
		return Course_Period;
	}
	public void setCourse_Period(String course_Period) {
		Course_Period = course_Period;
	}
	public Course(Integer course_Id, String course_Name, String short_Name, String description, Integer institution_Id,
			String course_Period) {
		super();
		Course_Id = course_Id;
		Course_Name = course_Name;
		Short_Name = short_Name;
		Description = description;
		Institution_Id = institution_Id;
		Course_Period = course_Period;
	}
	@Override
	public String toString() {
		return "Course [Course_Id=" + Course_Id + ", Course_Name=" + Course_Name + ", Short_Name=" + Short_Name
				+ ", Description=" + Description + ", Institution_Id=" + Institution_Id + ", Course_Period="
				+ Course_Period + "]";
	}
    
    
    
}
