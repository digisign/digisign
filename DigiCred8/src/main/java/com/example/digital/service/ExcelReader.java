package com.example.digital.service;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;

import com.monitorjbl.xlsx.StreamingReader;
import com.monitorjbl.xlsx.impl.StreamingCell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelReader.class);


    public List<Map<String, Object>> excelToMap(InputStream inputStream) throws IOException {
        Map<Integer, String> headerColMap = new LinkedHashMap<>();
        List<Map<String, Object>> objectsMap = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(9096).open(inputStream);
        System.out.println("read the file");
        for (Sheet currentSheet : workbook) {
            System.out.println(currentSheet.getSheetName());
            for (Row r : currentSheet) {
                if (r.getRowNum() == 0) {
                    Row header = r;
                    if (header != null) {
                        Iterator<Cell> cellIterator = header.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (cell != null && !cell.getStringCellValue().trim().equals("")) {
                                headerColMap.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
                            }
                        }
                    }
                } else {
                    Row currentRow = r;
                    if (currentRow != null) {
                        Map<String, Object> currRow = new LinkedHashMap<>();
                        if (currentRow != null) {
                            int startingCell= currentRow.getFirstCellNum();
                            int endingCell=currentRow.getLastCellNum();
                            while (startingCell<=endingCell) {
                                Cell cell = currentRow.getCell(startingCell, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                                // cell=new StreamingCell(startingCell,currentRow.getRowNum(),false);
                                if (cell != null && !cell.getCellTypeEnum().equals(CellType.BLANK) && !cell.getCellTypeEnum().equals(CellType._NONE)) {
                                    if (!keyAlreadyExists(headerColMap.get(cell.getColumnIndex()), currRow) && headerColMap.get(cell.getColumnIndex()) != null) {
                                        currRow.put(headerColMap.get(cell.getColumnIndex()), formatter.formatCellValue(cell).trim());
                                    }
                                }
                                startingCell++;
                            }
                        }
                        if (!CollectionUtils.sizeIsEmpty(currRow)) {
                            objectsMap.add(currRow);
                         
                            System.out.println("reading rows"+currRow);
                        }
                    }
                }

            }
            System.out.println("Completed converting excel sheet name:" + currentSheet.getSheetName());
        }
        System.out.println("Completed converting excel to java, number of students:" + objectsMap.size());
        return objectsMap;
    }


    public static boolean isColumnEmpty(Cell cell) {
        Cell c = cell;
        if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK)
            return true;
        return false;
    }


    private boolean keyAlreadyExists(String key,Map<String,Object> currRow) {
        return currRow.containsKey(key);
    }


}

