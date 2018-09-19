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


public class ContactRepositoryImpl implements ContactRepository {

	 private static final String FIND_ALL_SQL = "SELECT contactId,fullName,firstName, lastName,dOB,mobileNumber1,mobileNumber2,emailId1,emailId2 from  contact ";
	    private static final String INSERT_SQL = "INSERT INTO contact(fullName,firstName, lastName,dOB,mobileNumber1,mobileNumber2,emailId1,emailId2) values(?, ?, ?, ?, ?) ";

	    private Connection connection;

	    public ContactRepositoryImpl(DataSource dataSource) throws SQLException {
	        this.connection = dataSource.getConnection();
	    }

	    public ContactRepositoryImpl(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public List<Contact> findAllContact() {
	        List<Contact> result = new ArrayList<>();
	        try (Statement st = connection.createStatement();
	             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
	            while (rs.next()) {
	            	Integer contactId = rs.getInt("contactId");
	                String fullName=rs.getString("fullName");
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                Date dOB = rs.getDate("dOB");
	                Integer mobileNumber1 = rs.getInt("mobileNumber1");
	                Integer mobileNumber2 = rs.getInt("mobileNumber2");
	                String emailId1 = rs.getString("emailId1");
	                String emailId2 = rs.getString("emailId2");
	                result.add(new Contact(contactId, fullName,firstName, lastName,dOB,mobileNumber1,mobileNumber2,emailId1,emailId2));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    @Override
	    public void insertContact(Contact contact) {
	        if (contact != null) {
	            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
	                ps.setString(2, contact.getFullName());
	                ps.setString(3, contact.getFirstName());
	                ps.setString(4, contact.getLastName());
	                ps.setDate(5, contact.getDOB());
	                ps.setInt(6, contact.getMobileNumber1().intValue());
	                ps.setInt(7, contact.getMobileNumber2().intValue());
	                ps.setString(8, contact.getEmailId1());
	                ps.setString(9, contact.getEmailId2());
	                
	                int numRowsAffected = ps.executeUpdate();
	                try (ResultSet rs = ps.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        contact.setContactId(rs.getInt(1));
	                    }
	                } catch (SQLException s) {
	                    s.printStackTrace();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

		
}
