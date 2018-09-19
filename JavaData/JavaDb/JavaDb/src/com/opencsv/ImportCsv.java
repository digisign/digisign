package com.opencsv;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import au.com.bytecode.opencsv.CSVReader;

public class ImportCsv {

	
			
	

	public static void readCsv()
	{

	
		try (CSVReader reader = new CSVReader(new FileReader("E:\\DigitalCredentialXpress\\Data\\temporarydata.csv"), ','); 
                     Connection connection = DBConnection.getConnection();)
		{
				String insertQuery = "Insert into temporarydata (Institution_Name,Mobile_Number_1,Mobile_Number_2,Email_Id_1,Email_Id_2,Address_1,Address_2,Address_3,City,State,Country,Postal_Code) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = connection.prepareStatement(insertQuery);
				String[] rowData = null;
				int i = 0;
				while((rowData = reader.readNext()) != null)
				{
					for (String data : rowData)
					{
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

				String loadQuery = "LOAD DATA LOCAL INFILE '" + "E:\\DigitalCredentialXpress\\Data\\temporarydata.csv" + "' INTO TABLE temporarydata FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (Institution_Name, Mobile_Number_1, Mobile_Number_2, Email_Id_1, Email_Id_2, Address_1, Address_2, Address_3, City, State, Country, Postal_Code) ";
				System.out.println(loadQuery);
				Statement stmt = connection.createStatement();
				stmt.execute(loadQuery);
		}
		catch (Exception e)
		{
				e.printStackTrace();
		}
	}

}
