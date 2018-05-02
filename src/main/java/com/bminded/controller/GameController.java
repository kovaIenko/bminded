package com.bminded.controller;

import com.bminded.dto.GameData;
import com.bminded.dto.UserDTO;
import com.bminded.entity.GameEntity;
import com.bminded.entity.SubcategoryEntity;
import com.bminded.entity.UserEntity;
import com.bminded.service.GameService;
import com.bminded.service.LevelService;
import com.bminded.service.PointsService;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    @Autowired
    LevelService levelService;

    @Autowired
    PointsService pointsService;

    @GetMapping("/{game_name}")
    public ModelAndView game(@PathVariable String  game_name) {

        ModelAndView modelAndView = new ModelAndView(game_name);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); /* email */
        UserEntity user = userService.getOneByEmail(email);

        GameEntity game = gameService.getOneByName(game_name.toUpperCase().trim());
        SubcategoryEntity subcategoryEntity = pointsService.getOneByName("Volume memory");
       // System.out.println("======================================  "  + pointsService.getPoints(user.getId(),subcategoryEntity.getId()) );

        modelAndView.addObject("level",levelService.getlevel(user.getId(),game.getId()));
       modelAndView.addObject("points",pointsService.getPoints(user.getId(),subcategoryEntity.getId()));
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView games() {
        ModelAndView modelAndView = new ModelAndView("game");
        return modelAndView;
    }


    @PostMapping("/firefly") /* play*/
    public ResponseEntity<Void> updateFireFly(@RequestBody GameData game_date) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); /* email */
        UserEntity user = userService.getOneByEmail(email);
        GameEntity game = gameService.getOneByName("FIREFLY");
        SubcategoryEntity subcategoryEntity = pointsService.getOneByName("Volume memory");

        pointsService.update(user.getId(),subcategoryEntity.getId(), game_date.getPoints_forGame());
        levelService.updateLevel(user.getId(),game.getId(),game_date.getLevel_up());

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
