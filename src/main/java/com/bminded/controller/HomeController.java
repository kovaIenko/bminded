package com.bminded.controller;

import com.bminded.dto.UserDTO;
import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

     @Autowired
     UserService userService;

    @GetMapping("/")     /* index.html  */
    public ModelAndView home(){
        ModelAndView modelAndView =new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView =new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register( ) {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value ="/register", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody UserDTO user) {
       System.out.println(user);
        return "redirect:/index";
    }

    private UserEntity convertTo(UserDTO entity)
    {
        UserEntity user = new UserEntity();
        user.setEmail(entity.getEmail());
        return user;
    }

}
