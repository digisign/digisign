package com.example.digital.controller;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.FilePath;
import com.example.digital.entity.LearnerCredentialResource;
import com.example.digital.entity.LearnerCredentialResourceRequest;
import com.example.digital.entity.LearnerCredentialResourceResponse;
import com.example.digital.exception.DigiSignException;
import com.example.digital.service.LearnerCredentialResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Map;

@RestController

public class LearnerCredentialController {

    @Autowired
    private LearnerCredentialResourceService learnerCredentialResourceService;

    @RequestMapping(value="/credentialResource",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public LearnerCredentialResourceResponse save(@RequestBody LearnerCredentialResourceRequest learnerCredentialResourceRequest) throws Exception {
        return learnerCredentialResourceService.save(learnerCredentialResourceRequest);
    }


    @RequestMapping(value="users/{userId}/credentialResource",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> save(@PathVariable("userId") Long userId, @QueryParam(value="page") Integer page, @QueryParam(value="size") Integer size) throws Exception {
        PageRequest pageRequest=null;
        if(page!=null&&size!=null) {
            pageRequest= PageRequest.of(page,size,Sort.by("updatedDate").descending());
        }else{
            throw new DigiSignException(ErrorMessages.PAGINATED_PARAMS_NOT_AVALABLE.getCode(),ErrorMessages.PAGINATED_PARAMS_NOT_AVALABLE.getReasonPhrase());
        }
        return learnerCredentialResourceService.getLeranerCredentialResourceByUserId(userId,pageRequest);
    }

    @RequestMapping(value="user/{userId}/files" ,method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<LearnerCredentialResourceResponse> uploadFiles(@RequestParam("file") MultipartFile[] files,@PathVariable("userId") Long userId)  throws Exception{
        return  learnerCredentialResourceService.save(files,userId);
    }
}
