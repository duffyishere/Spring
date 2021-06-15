package org.duffy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		log.info("access denied: "+auth);
		
		model.addAttribute("msg", "Access denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
	
		log.info("custom login page");
		
		if(error!=null) {
			model.addAttribute("error", "Please check your id or password.");
			log.info("error : "+error);
		}
		else 
			log.info("Login Success!!");
		if(logout!=null) {
			model.addAttribute("logout", "Logout");
			log.info("Logout!");
		}
			
	}
	
	@GetMapping("customLogout")
	public void logoutGet() {
		
		log.info("custom logout.....");
	}
}
