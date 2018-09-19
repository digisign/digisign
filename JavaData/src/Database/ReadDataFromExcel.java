package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	
	
	public List<Map<String,Object>> readCSV() throws IOException{
		File file = new File("C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data\\tempdata.xlsx");
		InputStream is=new FileInputStream(file);
		ExcelReader er=new ExcelReader();
		List<Map<String,Object>> list=er.excelToMap(is);
		
		for (Map<String,Object> map:list) {
			for (Map.Entry<String,Object> rowEntry : map.entrySet()) {
			System.out.println(rowEntry.getKey() + " = " + rowEntry.getValue() + " ");
			}
			}
		return list;
	}
	
	
	

	/*public List<String> readCSV() throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)
		File file = new File("C:\\Users\\Hp\\Documents\\GitHub\\TestCredential\\data\\temporarydata (1).csv");
		
		
	
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int i;    
        while((i=br.read())!=-1){  
        System.out.print((char)i);  
        }  
        
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
}*/}