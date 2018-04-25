package com.bminded.controller;

import com.bminded.dto.UserDTO;
import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
     UserService userService;

    @GetMapping(value = "/account/{id}")
    public ModelAndView cabinet(@PathVariable long id) {
        System.out.println("helloooooooooooooooooooooooooooooooooooooooooo");
        ModelAndView modelAndView =new ModelAndView("account");

        UserEntity user = userService.getById(id);
       modelAndView.addObject("name", user.getFirst_name());
       modelAndView.addObject("surname", user.getSecond_name());
       modelAndView.addObject("email", user.getEmail());
       // modelAndView.addObject("photo", user.getEmail());
        return modelAndView;
    }

    @GetMapping("/statistic")
    public ModelAndView statistic()
    {
        ModelAndView modelAndView = new ModelAndView("statistic");
        return modelAndView;
    }






}
