package com.opencsv;

import java.sql.Connection;
import java.sql.DriverManager;

import Database.CSVLoader;
import Database.temporarydata;
import Database.temporarydataRepositoryImpl;

import Database.ReadDataFromExcel;
import au.com.bytecode.opencsv.CSVWriter;

public class DBConnection {
	public static void main(String[] args) throws Exception {
	
		CSVLoader csvLoader = new CSVLoader(getConnection());
		// TODO Auto-generated method stub
		
		temporarydataRepositoryImpl temporarydataRepositoryImpl = new temporarydataRepositoryImpl();
		ReadDataFromExcel CSVReader = new ReadDataFromExcel();
		
	 csvLoader.loadCSV("C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\temporarydata.csv", "temporarydata", true);
		temporarydata temporarydata = null;
		
		
		temporarydataRepositoryImpl.inserttemporarydata(temporarydata);
		
		ImportCsv cn =new ImportCsv();
	
		/*
		try {
			String filePath = "E:\\DigitalCredentialXpress\\Data\\temporarydata.csv";
			CSVLoader loader = new CSVLoader(getConnection());
			loader.loadCSV(filePath, "temporarytdata", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	



	public static Connection getConnection() throws Exception{
		Connection connection = null;
		try {
			String driver ="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/digitalcredx";
			String username = "root";
			String password = "Welcome@123";
			
			String filePath = "C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\temporarydata.csv";
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			
			} catch (Exception e) {System.out.println(e);}
		
		return connection;
		

	}
}