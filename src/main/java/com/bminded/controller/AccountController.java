package com.bminded.controller;

import com.bminded.entity.UserEntity;
import com.bminded.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping(value = "/account")
    public ModelAndView cabinet() {
        ModelAndView modelAndView = new ModelAndView("account");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); /* email */
        UserEntity user = userService.getOneByEmail(email);

        modelAndView.addObject("first_name", user.getFirst_name());
        modelAndView.addObject("second_name", user.getSecond_name());
        modelAndView.addObject("email", user.getEmail());

        if (user.getPhoto_ref() == null)
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

    @PostMapping("/upload")
    public RedirectView singleFileUpload(@RequestParam("file") MultipartFile file,
                                         RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        if (file.isEmpty()) {
            System.out.print("error");
        }

        try {
            String imgName = file.getOriginalFilename();

            File upl = new File("src/main/resources/static/profile_image/"+imgName);
            upl.createNewFile();
            FileOutputStream fout = new FileOutputStream(upl);
            fout.write(file.getBytes());
            fout.close();
            userService.setPhoto(email,"/profile_image/"+imgName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new RedirectView("/account");
    }

    @PostMapping("/change_name")
    public RedirectView changeName(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userService.getOneByEmail(email);
        userEntity.setFirst_name(name);
        userEntity.setSecond_name(surname);
        userService.updateUser(userEntity);
        return new RedirectView("/account");
    }



}
