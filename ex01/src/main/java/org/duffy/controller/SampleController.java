package org.duffy.controller;

import java.util.ArrayList;

import org.duffy.domain.SampleDTO;
import org.duffy.domain.SampleDTOList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		
		log.info("basic..........");
		
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		
		log.info("basic get........");
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicOnlyGet() {
		
		log.info("basic only get.........");
		
	}
	
	@RequestMapping("ex01")
	public String ex01(SampleDTO dto) {
		
		log.info(dto);
		
		return "ex01";
		
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info(name);
		log.info(age);
		
		return "ex02";
		
	}
	
//	http://localhost:8090/sample/ex02List?list%5B0%5D.name=zzunho&age=19&list%5B1%5D.name=Duffyd&age=20
	
	@RequestMapping("/ex02List")
	public String ex02List(SampleDTOList list) {
		
		log.info(list);
		
		return "/sample/ex02List";
		
	}
	
	@GetMapping("/rd01")
	public String rd01() {
		log.info("rd01.........");
		
		return "redirect:/sample/rd02";
	}
	
	@GetMapping("/rd02")
	public void rd02() {
		log.info("rd02.........");
		
	}
	
	@GetMapping("/fileupload")
	public void fileUpload() {
		log.info("file upload.......");
	}
	
	@PostMapping("/fileuploadPost")
	public void fileuploadPost(@RequestParam("file") ArrayList<MultipartFile> files) {
		log.info("fileuploadPost"); 
		
		files.forEach(file -> {
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
			log.info(file.getContentType());
			log.info("---------------------");
		});
	}
}
