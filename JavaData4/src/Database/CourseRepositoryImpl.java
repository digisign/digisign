package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CourseRepositoryImpl implements CourseRepository{

	

	 private static final String FIND_ALL_SQL = "SELECT Course_Id,Course_Name,Short_Name,Description,Institution_Id,Course_Period from  course ";
	    private static final String INSERT_SQL = "INSERT INTO course(Course_Id,Course_Name,Short_Name,Description,Institution_Id,Course_Period) values(?, ?, ?, ?,?,?) ";

	    private Connection connection;

	    public CourseRepositoryImpl(DataSource dataSource) throws SQLException {
	        this.connection = dataSource.getConnection();
	    }

	  
	    public CourseRepositoryImpl() {
			// TODO Auto-generated constructor stub
		}


		@Override
	    public List<Course> findAllCourse() {
	        List<Course> result = new ArrayList<>();
	        try (Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
	            while (rs.next()) {
	            	Integer Course_Id = rs.getInt("Course_Id");
	            	String Course_Name = rs.getString("Course_Name");
	            	String Short_Name=rs.getString("Short_Name");
	            	String Description = rs.getString("Description");
	                Integer Institution_Id = rs.getInt("Institution_Id");
	                String Course_Period = rs.getString("Course_Period");
	               
	               
	                result.add(new Course(Course_Id, Course_Name, Short_Name, Description,Institution_Id,Course_Period));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    @Override
	    public void insertCourse(Course course) {
	    
	        if (course != null) {
	            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
	                ps.setInt(1, course.getCourse_Id());
	                ps.setString(2, course.getCourse_Name());
	                ps.setString(3, course.getShort_Name());
	                ps.setString(4, course.getDescription());
	                ps.setInt(5, course.getInstitution_Id());
	                ps.setString(6, course.getCourse_Period());
	              
	                int numRowsAffected = ps.executeUpdate();
	                
	                }
	             catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

		
	        

}
