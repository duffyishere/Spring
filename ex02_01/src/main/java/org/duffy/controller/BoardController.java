package org.duffy.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.duffy.domain.BoardVO;
import org.duffy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping( "/board/*")
@AllArgsConstructor
//Error - 2021/03/21
//Intellij에서 WEB-INF/views를 참조하지 않고 out폴더를 참조함
//board/list를 접속해도 list.jsp를 연결해주지 않고 404Error, board/list.jsp로 해야먄 접속 가능
public class BoardController {

    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

//    @RequestMapping(value = "/board/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public void list(Model model){
        log.info("list.......");
        model.addAttribute("post", boardService.getPost(5L));
    }

    @GetMapping("/get")
    public void get(Long bno, Model model){
        log.info("get.......");
        model.addAttribute("post", boardService.getPost(bno));
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes redirectAttributes){
        log.info("register............"+boardVO);
        boardService.register(boardVO);
        redirectAttributes.addFlashAttribute("result", boardVO.getBno());
        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, RedirectAttributes redirectAttributes){
        log.info("modify.........."+boardVO);
        if(boardService.modify(boardVO)){
            redirectAttributes.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        log.info("remove......."+bno);
        if(boardService.remove(bno)){
            redirectAttributes.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }


}
