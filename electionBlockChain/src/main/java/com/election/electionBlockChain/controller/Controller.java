package com.election.electionBlockChain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


}
