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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        String filePath = request.getServletContext().getRealPath("/ ");
        if (file.isEmpty()) {
            System.out.print("error");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath + file.getOriginalFilename());
            Files.write(path, bytes);
            //href to save
            System.out.println(filePath + file.getOriginalFilename());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return new RedirectView("/account");
    }


}
