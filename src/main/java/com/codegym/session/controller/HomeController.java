package com.codegym.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    HttpSession httpSession;

    @GetMapping("/home")
    public String home(){
        Integer viewCount = (Integer) httpSession.getAttribute("viewCount");
        if(viewCount == null){
            viewCount = 1;
        } else {
            viewCount++;
        }
        httpSession.setAttribute("viewCount", viewCount);
        return "home";
    }
}
