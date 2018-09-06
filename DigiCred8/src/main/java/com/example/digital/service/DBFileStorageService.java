package com.example.digital.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.digital.entity.Learner_Credential_Resourse;
import com.example.digital.exception.FileStorageException;
import com.example.digital.exception.MyFileNotFoundException;
import com.example.digital.repository.FileRepository;

@Service
public class DBFileStorageService {

    @Autowired
    private FileRepository dbFileRepository;

    public Learner_Credential_Resourse storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw  new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Learner_Credential_Resourse dbFile = new Learner_Credential_Resourse(fileName, file.getContentType(), file.getBytes().toString());
 
            dbFile.getResourse().toString();
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Learner_Credential_Resourse getFile(Long fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
