package com.example.digital.controller;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.FilePath;
import com.example.digital.exception.DigiSignException;
import com.example.digital.exception.FileStorageException;
import com.example.digital.service.DBFileStorageService;
import com.example.digital.service.FileUploadService;
import com.example.digital.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.ws.rs.QueryParam;

import java.util.List;
import java.util.Map;

@RequestMapping("/")
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileUploadService fileUploadService;
/*
    private DBFileStorageService DBFileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	LearnerCredentialResource dbFile = DBFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getFileName())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
*/

    @RequestMapping(value="/files" ,method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<FilePath> uploadFiles(@RequestParam("file") MultipartFile[] files)  throws Exception{
       return  fileUploadService.uploadFiles(files);
    }
/*
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
    	Learner_Credential_Resourse dbFile = DBFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getResourse().getBytes()));
    }*/

    @RequestMapping(value="/files" ,method=RequestMethod.GET,produces = MediaType.ALL_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> downloadFile(@QueryParam(value="fileName") String fileName,@QueryParam("isThumbNail") boolean isThumbNail)  throws Exception {

        if(fileName==null){
           throw new DigiSignException(ErrorMessages.FILE_NAME_NOT_AVAILABLE.getReasonPhrase(),ErrorMessages.FILE_NAME_NOT_AVAILABLE.getCode());
        }

        byte[] bytes=fileUploadService.getDocument(fileName,isThumbNail);
        final HttpHeaders headers = new HttpHeaders();
        String fileBaseName= FilenameUtils.getBaseName(fileName);
        String fileType=FilenameUtils.getExtension(fileName);
        fileBaseName=fileBaseName.substring(0,fileBaseName.lastIndexOf("_"));
        headers.set("Content-Type", FileUploadUtil.getContentType(fileType));
        String header = "attachment; filename=" + fileBaseName + "." + fileType;
        headers.set("Content-Disposition", header);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }

}
