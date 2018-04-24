package com.bminded.controller;

import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
     UserService userService;

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ModelAndView cabinet(@PathVariable long id) {
        ModelAndView modelAndView =new ModelAndView("account");
        UserEntity user = userService.getById(id);
       modelAndView.addObject("name", user.getFirst_name());
       modelAndView.addObject("surname", user.getSecond_name());
       modelAndView.addObject("email", user.getEmail());
       // modelAndView.addObject("photo", user.getEmail());
        return modelAndView;
    }


}
