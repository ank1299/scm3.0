package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;

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
    public String registerPage(Model model){

        UserForm userForm = new UserForm();
        userForm.setName("Ankush");
        model.addAttribute("user", userForm);
        //default data

        System.out.println("register page loading");
        return  "register";
    }

    //processing register
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(){
        System.out.println("processRegister Method");
        //fetch the form data
        //UserForm
        //validate form data
        //save to db
        //message = "Registration succesfull"
        //redirect to login page
        return "redirect:/register";
    }
}
