package com.example.digital.util;


import com.example.digital.common.ExcelColumns;
import com.example.digital.common.FileType;
import com.example.digital.entity.ErrorRecord;
import com.example.digital.entity.Learner;
import com.example.digital.entity.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class FileToObjectConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileToObjectConverter.class);



    public Map<String,Object>  excelToBatches(InputStream inputStream) throws IOException {
        List<Map<String, Object>> mapList= excelToMap(inputStream);
        return mapToBatches(mapList);

    }

    public Map<String,Object>  csvToBatches(InputStream inputStream) throws IOException {
        List<Map<String, Object>> mapList= csvToMap(inputStream);
        return mapToBatches(mapList);

    }

    public List<Map<String, Object>> excelToMap(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        List<Map<String, Object>> objectsMap = new ArrayList<>();
        Map<Integer, String> headerColMap = new LinkedHashMap<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet currentSheet = workbook.getSheetAt(i);
            Row header = currentSheet.getRow(currentSheet.getFirstRowNum());
            if (header != null) {
                Iterator<Cell> cellIterator = header.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell != null && !cell.getStringCellValue().trim().equals("")) {
                        headerColMap.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
                    }
                }
            }

            //start from 1 as header is already taken care of.
            for (int j = 1; currentSheet != null && j < currentSheet.getPhysicalNumberOfRows(); j++) {
                Row currentRow = currentSheet.getRow(j);
                if (currentRow != null) {
                    DataFormatter formatter = new DataFormatter();
                    Map<String, Object> currRow = new LinkedHashMap<>();
                    if (currentRow != null) {
                        Iterator<Cell> cellIterator = currentRow.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (cell != null && !cell.getCellTypeEnum().equals(CellType.BLANK) && !cell.getCellTypeEnum().equals(CellType._NONE)) {
                                if(!keyAlreadyExists(headerColMap.get(cell.getColumnIndex()),currRow)&& headerColMap.get(cell.getColumnIndex())!=null) {
                                    currRow.put(headerColMap.get(cell.getColumnIndex()), formatter.formatCellValue(cell).trim());
                                }
                            }

                        }
                    }
                    if (!org.springframework.util.CollectionUtils.isEmpty(currRow)) {
                        objectsMap.add(currRow);
                    }
                }
            }
            LOGGER.debug("Completed converting excel sheet num:" + i);
        }
        LOGGER.debug("Completed converting excel to java, number of students:" + objectsMap.size());
        return objectsMap;
    }


    private boolean keyAlreadyExists(String key,Map<String ,Object> currRow){
        return currRow.containsKey(key);
    }


    public List<String> getExcelHeaders(InputStream inputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        List<Map<String, Object>> objectsMap = new ArrayList<>();
        Map<Integer, String> headerColMap = new LinkedHashMap<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet currentSheet = workbook.getSheetAt(i);
            Row header = currentSheet.getRow(currentSheet.getFirstRowNum());
            if (header != null) {
                Iterator<Cell> cellIterator = header.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell != null && !cell.getStringCellValue().trim().equals("")) {
                        // String header1 = cell.getStringCellValue().trim().replaceAll("[$#*+><!@ ]","");
                        headerColMap.put(cell.getColumnIndex(), cell.getStringCellValue().trim().toLowerCase().replaceAll("[-_ ]+", ""));
                    }

                }
            }
        }
        return new ArrayList<>(headerColMap.values());
    }

    public List<String> getCSVHeaders(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        String[] headers = line.split(",");
        Map<Integer, String> headerColMap = new LinkedHashMap<>();
        for (int i = 0; i < headers.length; i++) {
            if (headers != null && headers.length > 0 && !headers[i].trim().equals("") ) {
                // String header1 = headers[i].trim().replaceAll("[$#*+><!@ ]","");
                headerColMap.put(i,headers[i].trim());
            }
        }
        return new ArrayList(headerColMap.values());
    }

    public List<Map<String, Object>> csvToMap(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        String[] headers = line.split(",");
        Map<Integer, String> headerColMap = new LinkedHashMap<>();

        for (int i = 0; i < headers.length; i++) {
            if (headers != null && headers.length > 0 && !headers[i].trim().equals("")) {
                headerColMap.put(i, headers[i].trim());
            }
        }
        List<Map<String, Object>> objectsMap = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineTokens = line.split(",");
            if (lineTokens.length != 0) {
                Map<String, Object> currRow = new LinkedHashMap<>();
                for (int i = 0; i < lineTokens.length; i++) {
                    if(!keyAlreadyExists(headerColMap.get(i),currRow) && headerColMap.get(i)!=null) {
                        currRow.put(headerColMap.get(i), lineTokens[i].trim());
                    }
                }
                if (!org.springframework.util.CollectionUtils.isEmpty(currRow)) {
                    objectsMap.add(currRow);
                }
            }
        }
        LOGGER.debug("Completed converting csv to java, number of students:" + objectsMap.size());
        return objectsMap;
    }


    public Map<String,Object>  mapToBatches(List<Map<String, Object>> studentsMap) {

        if (studentsMap == null || studentsMap.size() == 0) return null;
        List<Learner> learners = new ArrayList<>();
        List<ErrorRecord> errorRecords=new ArrayList();
        for (Map<String, Object> map : studentsMap) {
            Learner learner=new Learner();
            //learner.setCreatedDate(new Date());
            //learner.setUpdatedDate(new Date());
            User user= new User();
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());
            boolean add = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String currentKey = entry.getKey().trim().toLowerCase().replaceAll("[-_ ]+", "");
                if (currentKey.equals(ExcelColumns.FIRSTNAME.getColName())) {
                    add = true;
                    user.setFirstName(String.valueOf(entry.getValue()));
                } else if (currentKey.equals(ExcelColumns.LASTNAME.getColName())) {
                    add = true;
                    user.setLastName(String.valueOf(entry.getValue()));
                } else if (currentKey.equals(ExcelColumns.LINKEDINURL.getColName())) {
                    add = true;
                    user.setLinkedinUrl(String.valueOf(entry.getValue()));
              /*  } else if (currentKey.equals(ExcelColumns.STARTDATE.getColName())) {
                    add = true;
                    //batch.setStartDate(String.valueOf(entry.getValue()));
                }else if (currentKey.equals(ExcelColumns.ENDDATE.getColName())) {
                    add = true;*/
                    //batch.setStartDate(String.valueOf(entry.getValue()));
                }else if (currentKey.equals(ExcelColumns.PHONENUMBER.getColName())) {
                    add = true;
                    user.setPhoneNumber(String.valueOf(entry.getValue()));
                }
               /* else if (currentKey.equals(ExcelColumns.BATCHNAME.getColName())) {
                    add = true;
                    batch.setName(String.valueOf(entry.getValue()));
                }*/
                else if (currentKey.equals(ExcelColumns.EMAIL.getColName())) {
                    add = true;
                    user.setEmail(String.valueOf(entry.getValue()));
                }
            }
            if(add) {
                    learners.add(learner);
                    learner.setUser(user);
            }
        }
        Map<String,Object> map=new HashMap();
        map.put("learners",learners);
        map.put("errorRecords",errorRecords);
        return map;
    }

    public List<String> getFileHeaders(InputStream inputStream, String fileType) throws Exception {
        if (fileType == null || fileType.trim().equals("")) {
            LOGGER.error("No file type specified");
            throw new UnsupportedOperationException("file type not supported");
        }
        if (fileType != null && fileType.toLowerCase().trim().equalsIgnoreCase(FileType.XLSX.getFileType())) {
            LOGGER.debug("Going to convert excel to java");
            return getExcelHeaders(inputStream);
        } else if (fileType != null && fileType.toLowerCase().trim().equalsIgnoreCase(FileType.CSV.getFileType())) {
            LOGGER.debug("Going to convert csv to java");
            return getCSVHeaders(inputStream);
        }
        LOGGER.error("Unsupported file type. IGNORED.");
        return null;
    }



    /**
     * @param inputStream
     * @param fileType    currently supports xlsx and csv
     * @return
     */
    public Map<String,Object>  fileToJava(InputStream inputStream, String fileType) throws Exception {
        if (fileType == null || fileType.trim().equals("")) {
            LOGGER.error("No file type specified");
            throw new UnsupportedOperationException("file type not supported");
        }
        if (fileType != null && fileType.toLowerCase().trim().equalsIgnoreCase(FileType.XLSX.getFileType())) {
            LOGGER.debug("Going to convert excel to java");
            return excelToBatches(inputStream);
        } else if (fileType != null && fileType.toLowerCase().trim().equalsIgnoreCase(FileType.CSV.getFileType())) {
            LOGGER.debug("Going to convert csv to java");
            return csvToBatches(inputStream);
        }
        LOGGER.error("Unsupported file type. IGNORED.");
        return null;
    }

}


