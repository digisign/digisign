package Database;

import java.sql.Date;

public class Contact {
	private Integer ContactId;
    private String FullName;
    private String FirstName;
    private String LastName;
    private  Date DOB;
    private Integer MobileNumber1;
    private Integer MobileNumber2;
    private String EmailId1;
    private String EmailId2;
	public Integer getContactId() {
		return ContactId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [ContactId=");
		builder.append(ContactId);
		builder.append(", FullName=");
		builder.append(FullName);
		builder.append(", FirstName=");
		builder.append(FirstName);
		builder.append(", LastName=");
		builder.append(LastName);
		builder.append(", DOB=");
		builder.append(DOB);
		builder.append(", MobileNumber1=");
		builder.append(MobileNumber1);
		builder.append(", MobileNumber2=");
		builder.append(MobileNumber2);
		builder.append(", EmailId1=");
		builder.append(EmailId1);
		builder.append(", EmailId2=");
		builder.append(EmailId2);
		builder.append("]");
		return builder.toString();
	}

	public Contact(Integer contactId, String fullName, String firstName, String lastName, Date dOB, Integer mobileNumber1,
			Integer mobileNumber2, String emailId1, String emailId2) {
		super();
		ContactId = contactId;
		FullName = fullName;
		FirstName = firstName;
		LastName = lastName;
		DOB = dOB;
		MobileNumber1 = mobileNumber1;
		MobileNumber2 = mobileNumber2;
		EmailId1 = emailId1;
		EmailId2 = emailId2;
	}

	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Integer getMobileNumber1() {
		return MobileNumber1;
	}
	public void setMobileNumber1(Integer mobileNumber1) {
		MobileNumber1 = mobileNumber1;
	}
	public Integer getMobileNumber2() {
		return MobileNumber2;
	}
	public void setMobileNumber2(Integer mobileNumber2) {
		MobileNumber2 = mobileNumber2;
	}
	public String getEmailId1() {
		return EmailId1;
	}
	public void setEmailId1(String emailId1) {
		EmailId1 = emailId1;
	}
	public String getEmailId2() {
		return EmailId2;
	}
	public void setEmailId2(String emailId2) {
		EmailId2 = emailId2;
	}

	public void setContactId(Integer long1) {
		// TODO Auto-generated method stub
		
	}
	

 

}
