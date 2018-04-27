package com.bminded.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping("/{game_name}")
    public ModelAndView game(@PathVariable String  game_name) {
        ModelAndView modelAndView =new ModelAndView(game_name);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView games() {
        ModelAndView modelAndView =new ModelAndView("game");
        return modelAndView;
    }
}
