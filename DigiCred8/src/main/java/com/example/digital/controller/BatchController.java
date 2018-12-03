package com.example.digital.controller;

import com.example.digital.entity.Batch;
import com.example.digital.service.BatchUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/")
@RestController
public class BatchController {

    @Autowired
    private BatchUploadService batchUploadService;

    @RequestMapping(value="/batches" ,method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Batch saveBatch(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("startDate") String startDate, @RequestParam(name="endDate",required = false) String endDate, @RequestParam("course") String course, @RequestParam(name="description",required = false) String description)  throws Exception{
        return batchUploadService.saveBatches(file,name,startDate,endDate,course,description);
    }

    @RequestMapping(value="/batches" ,method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Batch> getBatches(){
        return  batchUploadService.getAllBatches();
    }

    @RequestMapping(value="/batches/{batchId}" ,method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Batch getBatch(@PathVariable(value="batchId") Long batchId){
        return  batchUploadService.getBatch(batchId);
    }

}
