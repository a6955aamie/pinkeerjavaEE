package com.example.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";//跳转到lohon。jsp
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
