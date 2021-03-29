package org.duffy.controller;

import org.duffy.domain.BoardVO;
import org.duffy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	
	public BoardController() {}

	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService; 
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(Model model) {
		log.info("list.........");
		
		model.addAttribute("list", boardService.getListAll());
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public void get(Long bno, Model model) {
		log.info("get........."+bno);
		
		boardService.getList(bno);
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register........."+board);
		
		boardService.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify..........."+board.getBno());
		
		if(boardService.modify(board))
			rttr.addFlashAttribute("result", "success");
			
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("modify..........."+bno);
		
		if(boardService.remove(bno))
			rttr.addFlashAttribute("result", "success");
			
		return "redirect:/board/list";
	}
}
