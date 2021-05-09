package org.duffy.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

    @GetMapping("/list")
    public void list(){

        log.info("list,,,,,,,");
    }
}
