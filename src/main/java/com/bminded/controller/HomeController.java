package com.bminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;


@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView =new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView =new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView register() {
        ModelAndView modelAndView =new ModelAndView("register");
        return modelAndView;
    }
}
