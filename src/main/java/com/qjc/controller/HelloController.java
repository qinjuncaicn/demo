package com.qjc.controller;

import com.qjc.model.User;
import com.qjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * test
 */
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String index(Model model){
        User user = userService.querUser();
        model.addAttribute("user",user);
        return "hello";
    }
}
