package com.example.digital.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.digital.service.ExcelService;

@RestController
public class ExcelController {
	
	private final ExcelService excelService;
	
	public ExcelController(ExcelService excelService) {
		
		this.excelService =excelService;
	}

	@PostMapping("/upload")
	public List<Map<String, String>> upload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws Exception  {
	
		long size = file.getSize();

        if(size > 10000000)
        {
            redirectAttributes.addFlashAttribute("message",
                    "You file " + file.getOriginalFilename() + "! has not been successfully uploaded. Requires less than 10 MB size.");
         //   return "redirect:/upload";
        }
		return	excelService.upload(file);
	}
}
