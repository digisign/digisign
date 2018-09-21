package com.example.digital.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.digital.util.ExcelUtil;
@Service
public class ExcelService {
	
	private final ExcelUtil excelUtil;
	
	
	public ExcelService(ExcelUtil excelUtil) {
		this.excelUtil=excelUtil;
	}
	

	public List<Map<String, String>> upload(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		Path tempDir = Files.createTempDirectory("");
		File tempFile= tempDir.resolve(file.getOriginalFilename()).toFile();
		file.transferTo(tempFile);
		Workbook workbook=WorkbookFactory.create(tempFile);
		Sheet sheet= workbook.getSheetAt(0);
		Supplier<Stream<Row>> rowStreamSupplier=excelUtil.getRowStreamSupplier(sheet);
		Row headerRow =rowStreamSupplier.get().findFirst().get();
		List<String> headerCells=StreamSupport.stream(headerRow.spliterator(), false)
				.map(Cell::getStringCellValue)
				.collect(Collectors.toList());
		
		int colCount = headerCells.size();
		
		
		return rowStreamSupplier.get()  
		
		/*.forEach(row->*/
		/*Stream<Cell>*/ 
		.map(row -> 
		{
		List<String> cellList=StreamSupport.stream(row.spliterator(), false)
				.map(Cell::getStringCellValue)
				.collect(Collectors.toList());
		
		/*List<String> cellVals= cellStream.map(cell -> {
			String cellval = cell.getStringCellValue();
			return cellval;
		})
		.collect(Collectors.toMap(keyMapper, valueMapper));
		Map<String,String> cellMap*/
		
	return IntStream.range(0, colCount)
				.boxed()
				.collect(Collectors.toMap(
						index -> headerCells.get(index),
						index -> cellList.get(index)));
		
		//System.out.println(cellMap);
		}).collect(Collectors.toList());
		
		
		
	}

}
