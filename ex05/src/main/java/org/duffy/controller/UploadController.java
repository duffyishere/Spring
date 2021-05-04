package org.duffy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.duffy.domain.AttachDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

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
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
		log.info("upload ajax");
	}
	
	private String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
	@PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachDTO>> uploadAjaxActionPost(MultipartFile[] uploadFiles) {
		
		List<AttachDTO> list = new ArrayList<AttachDTO>();
		
		String uploadFolder = "/Users/zzun_ho9/upload";

		File  uploadPath = new File(uploadFolder, getFolder());
		log.info(uploadPath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile file : uploadFiles) {
			AttachDTO attach = new AttachDTO();
			
			log.info("Upload file name :"+file.getOriginalFilename());
			log.info("Upload file size :"+file.getSize()+"KB");
			log.info("--------------------------------------------------");

			String uploadFileName = file.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
			log.info("only file name :"+uploadFileName);
			
			attach.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid + "_"+ uploadFileName;
			
			attach.setUuid(String.valueOf(uuid));
			attach.setUploadPath(uploadFolder);
			
//			File saveFile = new File(uploadFolder, uploadFileName);

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				file.transferTo(saveFile);
				if(checkImage(saveFile)) {
					attach.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					
					Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
					
					thumbnail.close();
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}//end catch
			
			list.add(attach);
		}//end for	

		return new ResponseEntity<List<AttachDTO>> (list, HttpStatus.OK);
	}
	
	private boolean checkImage(File file) {
		try {
			
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}