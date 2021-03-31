package org.duffy.controller;

import org.duffy.domain.BoardVO;
import org.duffy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@NoArgsConstructor 
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService; 
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(Model model) {
		log.info("/list");
		
		model.addAttribute("list", boardService.getListAll());
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public void get(Long bno, Model model) {
		log.info("/get?bno="+bno);
		
		
		model.addAttribute("post", boardService.getList(bno));
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register complete "+board.getBno());
		
		boardService.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void register() {
		log.info("/register");
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify complete "+board.getBno());
		
		if(boardService.modify(board))
			rttr.addFlashAttribute("result", "success");
			
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modify(Long bno, Model model) {
		log.info("/modify?bno="+bno);
		model.addAttribute("post", boardService.getList(bno));
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove complete "+bno);
		
		if(boardService.remove(bno))
			rttr.addFlashAttribute("result", "success");
			
		return "redirect:/board/list";
	}
}
