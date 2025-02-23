package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        //sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn code with durgesh");
        model.addAttribute("githubRepository", "https://github.com/LearnCodeWithDurgesh/scm2.0");
        return "home";
    }

    //about route
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("About page loading");
        return  "about";
    }

    //services route
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("services page loading");
        return  "services";
    }

    //contact page
    @RequestMapping("/contact")
    public String contactPage(){
        System.out.println("contact page loading");
        return  "contact";
    }

    //login page
    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("login page loading");
        return  "login";
    }

    //register page
    @RequestMapping("/register")
    public String registerPage(){
        System.out.println("register page loading");
        return  "register";
    }
}
