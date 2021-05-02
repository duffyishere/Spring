package org.duffy.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadActionFormPost(MultipartFile[] uploadFiles, Model model) {
		
		String uploadFolder = "/Users/zzun_ho9/upload";

		
		for(MultipartFile file : uploadFiles) {
			
			log.info("--------------------------------");
			log.info("Upload file name :"+file.getOriginalFilename());
			log.info("Upload file size :"+file.getSize());
			
			File saveFile = new File(uploadFolder, file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}//end catch
			
		}//end for
		
	}
	
}
