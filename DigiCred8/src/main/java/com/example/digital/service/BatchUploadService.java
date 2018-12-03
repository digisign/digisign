package com.example.digital.service;


import com.example.digital.entity.Batch;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface BatchUploadService {
    Batch saveBatches(MultipartFile file, String batchName, String startDate, String endDate, String courseName, String description) throws Exception ;
    List<Batch> getAllBatches();
    Batch getBatch(Long batchId);
}
