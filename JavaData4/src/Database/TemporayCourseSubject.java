package Database;

public class TemporayCourseSubject {
	
	private String Institution_Name;
	private String	CourseName;
	private String Course_Period;
	private String SubjectName;
	
	public TemporayCourseSubject(String institutionName, String courseName, String course_Period,String subjectName) {
		super();
		Institution_Name = institutionName;
		CourseName = courseName;
		Course_Period = course_Period;
		SubjectName=subjectName;
	}

	public String getInstitutionName() {
		return Institution_Name;
	}

	public void setInstitutionName(String institutionName) {
		Institution_Name = institutionName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName; 	
	}
	
	public String getCourse_Period() {
		return Course_Period;
	}

	public void setCourse_Period(String course_Period) {
		Course_Period = course_Period;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TemporayCourseSubject [InstitutionName=");
		builder.append(Institution_Name);
		builder.append(", CourseName=");
		builder.append(CourseName);
		builder.append(", Course_Period=");
		builder.append(Course_Period);
		builder.append(", SubjectName=");
		builder.append(SubjectName);
		builder.append("]");
		return builder.toString();
	}

	

}
