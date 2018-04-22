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

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView =new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/signIn")
    public ModelAndView registry() {
        ModelAndView modelAndView =new ModelAndView("signIn");
        return modelAndView;
    }
}
