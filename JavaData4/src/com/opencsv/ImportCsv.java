package com.opencsv;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import au.com.bytecode.opencsv.CSVReader;

public class ImportCsv {

	
			
	

	public static void readCsv()
	{

	
		try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data\\Subject1.csv"), ',');
                     Connection connection = DBConnection.getConnection();)
		{
				String insertQuery = "Insert into tempcsdata (Institution_Name,Course_Name,Course_Period,SubjectName) values (?,?,?,?)";
				PreparedStatement pstmt = connection.prepareStatement(insertQuery);
				String[] rowData = null;
				int i = 0;
				while((rowData = reader.readNext()) != null)
				{
					for (String data : rowData)
					{
						/*String[] arr = data.split(",");
						pstmt.setString(1, arr[0]);
						pstmt.setString(2, arr[1]);
						pstmt.setString(3, arr[2]);
						pstmt.setString(4, arr[3]);*/
						
						
						System.out.println("new line"+data);
							/*pstmt.setString((i % 3), data);
							if (++i % 3 == 0)
									pstmt.addBatch();// add batch
							if (i % 30 == 0)
									pstmt.executeBatch();*/
					}
				}
				System.out.println("Data Successfully Uploaded");
		}
		catch (Exception e)
		{
				e.printStackTrace();
		}

	}

	public static void readCsvUsingLoad()
	{

		try (Connection connection = DBConnection.getConnection())
		{

			String filename = "C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data\\Subject1.csv";
		    String tablename = "tempcsdata";
				String loadQuery = "LOAD DATA LOCAL INFILE \"" + filename + "\" INTO TABLE"+ tablename+" FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n'  ";
				System.out.println(loadQuery);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery);
		}
		catch (Exception e)
		{/*(Institution_Name, CourseName, Course_Period, SubjectName)*/
				e.printStackTrace();
		}
	}

}