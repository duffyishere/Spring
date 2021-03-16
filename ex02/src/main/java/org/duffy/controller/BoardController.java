package org.duffy.controller;

import org.duffy.domain.BoardVO;
import org.duffy.domain.Criteria;
import org.duffy.domain.PageDTO;
import org.duffy.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("")
	public void basic() {
		log.info("basic..........");
	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info(cri);
		log.info("list............");
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 770));
	}
//	public void list(Model model) {
//		log.info("list............");
//		
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		model.addAttribute("board", service.get(bno));
	}
	
	@GetMapping("/register")
	public void registerGET() { }
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr ) {
		log.info(board);
		
		service.register(board);
		
		return "redirect:/board/list"; 
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		
		int count = service.modify(board);

		rttr.addFlashAttribute("result", count==1 ? "success":"false");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board/list"; 
	}
	
	@PostMapping("/remove")
	public String delete(Long bno, RedirectAttributes rttr) {
		
		int count = service.remove(bno);

		rttr.addFlashAttribute("result", count==1 ? "success":"false");
		
		return "redirect:/board/list"; 
	}
}
