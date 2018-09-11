package com.example.digital.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileUploadService {
     String uploadFile(File file) throws Exception;
     String getThumbNail(File sourceFile) throws IOException;
     Map<String,List<String>> uploadFiles(MultipartFile[] sourceFile) throws Exception;
     byte[] getDocument(String downloadLink,boolean isThumbNail) throws Exception;
}
