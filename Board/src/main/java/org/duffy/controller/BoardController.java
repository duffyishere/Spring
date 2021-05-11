package org.duffy.controller;

import org.duffy.domain.BoardVO;
import org.duffy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;

	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("/list");

		model.addAttribute("post", boardService.getList());
	}
	
	@GetMapping("/post")
	public void post(Long bno, Model model) {
		
		log.info("/post?bno"+bno);
		
		model.addAttribute("post", boardService.read(bno));
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes attributes) {
		
		log.info("/remove?bno"+bno);
		
		attributes.addFlashAttribute(boardService.remove(bno));
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes attributes) {
		Long bno = board.getBno();
		
		log.info("/remove?bno"+bno);
		
		attributes.addFlashAttribute(boardService.remove(bno));
		
		return "redirect:/board/list";
	}
	
}
