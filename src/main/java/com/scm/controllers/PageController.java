package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Value("${user.profilePic.path}")
    private String profilePic;

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
        // userForm.setName("Ankush");
        model.addAttribute("user", userForm);

        System.out.println("register page loading");
        return  "register";
    }

    //processing register
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute("user") UserForm userForm, BindingResult rbindingResult, HttpSession session){
    // public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rbindingResult, HttpSession session){
        System.out.println("processRegister Method");
        //fetch the form data
        //UserForm
        System.out.println(userForm);
        //validate form data

        if(rbindingResult.hasErrors()){
            System.out.println("Error found");
            return "register";
        }

        //save to db
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic(profilePic)
        .build();
        
        User savedUser = userService.saveUser(user);
        System.out.println("User saved");
        //message = "Registration succesfull"
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);
        // session.setAttribute("message","Registration successfull");

        //redirect to login page
        return "redirect:/register";
    }
}
