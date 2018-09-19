package Database;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public   class temporarydataRepositoryImpl implements temporarydataRepository {

	/* private static final String FIND_ALL_SQL = "SELECT InstitutionName,MobileNumber1,MobileNumber2,EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode from  temporarydata ";
	 private static final String INSERT_SQL = "INSERT INTO temporarydata(InstitutionName,MobileNumber1,MobileNumber2,EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
*/
	 private static final String FIND_ALL="SELECT Institution_Name,CourseName,Course_Period,SubjectName from course_subject";
	 private static final String INSERT_CS="INSERT INTO course_subject(Institution_Name,CourseName,Course_Period,SubjectName) values(?, ?, ?, ?)";
	 
	    private Connection connection;

	    public temporarydataRepositoryImpl(DataSource dataSource) throws SQLException {
	        this.connection = dataSource.getConnection();
	    }

	  
	    public temporarydataRepositoryImpl() {
			// TODO Auto-generated constructor stub
		}


		/*@Override
	    public List<temporarydata> findAlltemporarydata() {
	        List<temporarydata> result = new ArrayList<>();
	        try (Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
	            while (rs.next()) {
	            	String InstitutionName = rs.getString("InstitutionName");
	            	Integer MobileNumber1=rs.getInt("MobileNumber1");
	            	Integer MobileNumber2 = rs.getInt("MobileNumber2");
	                String EmailId1 = rs.getString("EmailId1");
	                String EmailId2 = rs.getString("EmailId2");
	                String Address1 = rs.getString("Address1");
	                String Address2 = rs.getString("Address2");
	                String Address3 = rs.getString("Address3");
	                String City = rs.getString("City");
	                String State = rs.getString("State");
	                String Country = rs.getString("Country");
	                Integer PostalCode = rs.getInt("PostalCode");
	                result.add(new temporarydata(InstitutionName, MobileNumber1, MobileNumber2, EmailId1,EmailId2,Address1,Address2,Address3,City,State,Country,PostalCode));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    @Override
	    public void inserttemporarydata(temporarydata temporarydata) {
	    
	        if (temporarydata != null) {
	            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
	                ps.setString(1, temporarydata.getInstitutionName());
	                ps.setInt(2, temporarydata.getMobileNumber1());
	                ps.setInt(3, temporarydata.getMobileNumber2());
	                ps.setString(4, temporarydata.getEmailId1());
	                ps.setString(5, temporarydata.getEmailId2());
	                ps.setString(6, temporarydata.getAddress1());
	                ps.setString(7, temporarydata.getAddress2());
	                ps.setString(8, temporarydata.getAddress3());
	                ps.setString(9, temporarydata.getCity());
	                ps.setString(10, temporarydata.getState());
	                ps.setString(11,  temporarydata.getCountry());
	                ps.setInt(12, temporarydata.getPostalCode());
	                
	                int numRowsAffected = ps.executeUpdate();
	                
	                }
	             catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

*/
		@Override
		public List<TemporayCourseSubject> findAlltemporaryCS() {
			// TODO Auto-generated method stub
			List<TemporayCourseSubject> result = new ArrayList<>();
	        try (Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(FIND_ALL)) {
	            while (rs.next()) {
	            	String Institution_Name = rs.getString("Institution_Name");
	            	String CourseName = rs.getString("CourseName");
	                String Course_Period = rs.getString("Course_Period");
	               String SubjectName = rs.getString("SubjectName");	               
	                result.add(new TemporayCourseSubject(Institution_Name, CourseName, Course_Period,SubjectName));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
		}


		@Override
		public void inserttemporaryCS(TemporayCourseSubject temporarycs){
			// TODO Auto-generated method stub
			if (temporarycs != null) {
				
	            try (PreparedStatement ps = connection.prepareStatement(INSERT_CS, Statement.RETURN_GENERATED_KEYS)) {
	               //for(TemporayCourseSubject tcs:temporarycs) {
	            	ps.setString(1, temporarycs.getInstitutionName());
	                ps.setString(2, temporarycs.getCourseName());
	                ps.setString(3, temporarycs.getCourse_Period());
	                ps.setString(4, temporarycs.getSubjectName());
	              
	                int numRowsAffected = ps.executeUpdate();
	             
	               
	                }
	             catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		}
		}
