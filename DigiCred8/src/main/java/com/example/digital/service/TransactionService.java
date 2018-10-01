package com.example.digital.service;

import com.example.digital.entity.CourseConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface TransactionService  {

     void saveCourses(Map<CourseConverter, List<CourseConverter>> courseConverterListMap) throws Exception;

}
