package com.bminded.controller;

import com.bminded.dto.UserDTO;
import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO user) {
       //System.out.println(user);

        if(userService.isEmailExist(user.getEmail()))   /* перевірити */
            /* повертати проблему на фронтенд */
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
          //  System.out.println("The is email");

        userService.addUser(convertTo(user));
        userService.addUserRole(user.getEmail(),"ROLE_USER");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/403")
    public ModelAndView forbidden() {
        ModelAndView modelAndView=new ModelAndView("403");
        return modelAndView;
    }
    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView=new ModelAndView("error");
        return modelAndView;
    }

    private UserEntity convertTo(UserDTO entity)
    {
        UserEntity user = new UserEntity();
        user.setEmail(entity.getEmail());
        user.setPhoto_ref(entity.getPhoto_ref());
        user.setFirst_name(entity.getFirst_name());
        user.setSecond_name(entity.getSecond_name());
        user.setPassword(entity.getPassword());
        user.setCurrency(entity.getCurrency());
        return user;
    }

}
