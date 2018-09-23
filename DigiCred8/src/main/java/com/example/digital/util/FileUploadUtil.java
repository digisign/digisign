package com.example.digital.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileUploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);

    public static File frameFileData(MultipartFile inputFile) throws IOException {
        File newFile = new File(inputFile.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(inputFile.getBytes());
        fos.close();
        return newFile;
    }

    public static void clearTempFiles(File[] files) {
        if (files == null)
            return;
        Arrays.asList(files).forEach(file -> {
            if (file != null)
                file.delete();
        });
    }



    public static String getContentType(String fileExt) {
        switch (fileExt.toLowerCase()) {
            case "csv":
            case ".csv":
                return "text/csv";
            case "xlsx":
            case ".xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "pdf":
            case ".pdf":
                return "application/pdf";
            case ".png":
            case "png":
                return "image/png";
            case ".jpg":
            case "jpg":
                return "image/jpg";
            case ".gif":
            case "gif":
                return "image/gif";
            default:
                return "document/html";
        }
    }


}
