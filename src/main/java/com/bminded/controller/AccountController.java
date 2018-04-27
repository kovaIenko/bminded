package com.bminded.controller;

import com.bminded.dto.UserDTO;
import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/account")
    public ModelAndView cabinet() {
        ModelAndView modelAndView = new ModelAndView("account");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); /* email */
        UserEntity user = userService.getOneByEmail(email);

        modelAndView.addObject("first_name", user.getFirst_name());
        modelAndView.addObject("second_name", user.getSecond_name());
        modelAndView.addObject("email", user.getEmail());

        if (user.getPhoto_ref()==null)
            modelAndView.addObject("photo", "/images/default-avatar.png");
       else
            modelAndView.addObject("photo", user.getPhoto_ref());

    return modelAndView;

    }

    @GetMapping("/statistic")
    public ModelAndView statistic() {
        ModelAndView modelAndView = new ModelAndView("statistic");
        return modelAndView;
    }


}
