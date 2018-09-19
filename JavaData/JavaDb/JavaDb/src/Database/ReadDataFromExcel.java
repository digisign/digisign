package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/

public class ReadDataFromExcel {

	// Java Program to illustrate reading from FileReader
	// using BufferedReader

	public List<String> readCSV() throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)
		File file = new File("E:\\DigitalCredentialXpress\\Data\\temporarydata.csv");
		
	
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		/*int i;    
        while((i=br.read())!=-1){  
        System.out.print((char)i);  
        } */ 
        
		System.out.println(file);
		String stringReader = br.readLine();
		List<String> lines=new ArrayList<>();
		
		String st;
		while (stringReader!= null){
				lines.add(stringReader);
		stringReader =br.readLine();
		}
		System.out.println("lines"+lines.size());
		return lines;
}}