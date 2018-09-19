package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Database.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception {
		getConnection();
		
	}

	



	public static Connection getConnection() throws Exception{
		Connection connection = null;
		try {
			String driver ="com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/digitalcredx?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "Welcome@123";
			
			String filePath = "C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data";
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			ReadDataFromExcel read = new ReadDataFromExcel();
            List<String> lines = read.readCSV();
            System.out.println("total lines from csv :"+lines.size());
            String sql = "Insert IGNORE into tempcsdata(Institution_Name,Course_Name,Course_Period,Subject_Name) values(?, ?, ?,?)";
            PreparedStatement ps = null;
            for(Integer i = 1 ; i<lines.size(); i++){
				String line = lines.get(i);
            	if (line != null) 
            		
				{System.out.println(line);
					String[] fields = line.split(",");
					System.out.println("Length"+fields.length);
					Integer rowIndex = 1;
					 ps = connection.prepareStatement(sql);
					for(String fieldValue:fields)
					{
						if(fieldValue == null || fieldValue == "" || fieldValue == " " || fieldValue.isEmpty() || fieldValue.length() == 0 ||fieldValue==" \n") {
							System.out.println("Row index IN IF "+rowIndex);
							ps.setString(rowIndex,null);
							rowIndex++;
							continue;
					 	}
					    System.out.println("Row index"+rowIndex+": Result "+fieldValue);
						ps.setString(rowIndex,fieldValue);
						rowIndex++;

					}
					ps.executeUpdate();			
					
				}
			}
            
            String query = "SELECT DISTINCT Institution_Id,Course_Name,Course_Period FROM tempcsdata ,Institution where institution.Institution_Name=tempcsdata.Institution_Name ";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList al = null;
            al = new ArrayList();

            PreparedStatement ps1 = connection.prepareStatement("INSERT IGNORE INTO course (Course_Name,Course_Period,Institution_Id) values(?,?,?)");
            List lstInstituteNames = new ArrayList();
            while (rs.next()) {
            	String Course_Name = rs.getString("Course_Name");
            	//System.out.println("Full_Name"+Full_Name);
            	String Course_Period = rs.getString("Course_Period");
            	Integer Institution_Id=rs.getInt("Institution_Id");                         		
                ps1.setString(1, Course_Name);
                ps1.setString(2, Course_Period);
                ps1.setInt(3, Institution_Id);
               
                int status = ps1.executeUpdate();
             //   System.out.println("status"+status);
                 }
            //System.out.println("lstInstituteNames"+lstInstituteNames);
            String query1 = "SELECT c.Course_Id,tcd.Institution_Name,c.Course_Name,c.Course_Period,tcd.Subject_Name from tempcsdata tcd,course c where tcd.Course_Name=c.Course_Name";

            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
            ArrayList al1 = null;
            al1 = new ArrayList();

            PreparedStatement ps2 = connection.prepareStatement("INSERT IGNORE INTO subject (Subject_Name, Course_Id) values(?,?)");
            PreparedStatement ps3 = connection.prepareStatement("INSERT IGNORE INTO errorcsdata ( Institution_Name,Course_Name,Course_Period,Subject_Name) values(?,?,?,?)");
            // List lstInstituteNames = new ArrayList();
            while (rs1.next()) {
            	
            	String Institution_Name = rs1.getString("Institution_Name");
            	System.out.println("Institution_Name"+Institution_Name);
            	String Course_Name = rs1.getString("Course_Name");
            	System.out.println("Course_Name"+Course_Name);
            	String Course_Period = rs1.getString("Course_Period");
            	System.out.println("Course_Period"+Course_Period);
            	String Subject_Name = rs1.getString("Subject_Name");
            	System.out.println("SubjectName"+Subject_Name);
            	String Course_Id =rs1.getString("Course_Id");
            	
            	
            	
            	     		
            	            	
            	ps3.setString(1, Institution_Name);
        		ps3.setString(2, Course_Name);
        		ps3.setString(3, Course_Period);
        		ps3.setString(4, Subject_Name);     	
          		             
                int status = ps3.executeUpdate();
                System.out.println("status"+status);
                
                ps2.setString(1, Subject_Name);
                ps2.setString(2, Course_Id);  
                	 
                   int status1 = ps2.executeUpdate();
             		System.out.println("status1"+status1);
             		
             		 String deletequery = "delete from tempcsdata";
                     PreparedStatement ps4 = connection.prepareStatement(deletequery); 
                     ps4.executeUpdate();
                 }
             ps.close();
			} catch (Exception e) {
					//System.out.println(e.)
					System.out.println(e);
			}
		return connection;
	}
	

}
