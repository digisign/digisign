package com.example.digital.service;

import org.springframework.stereotype.Service;

@Service
public class DBFileStorageService {

 /*   @Autowired
    private FileRepository dbFileRepository;

    public LearnerCredentialResource storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw  new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            LearnerCredentialResource dbFile = new LearnerCredentialResource(fileName, file.getContentType(), file.getBytes().toString());
 
            dbFile.getResourse().toString();
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public LearnerCredentialResource getFile(Long fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }*/
}
