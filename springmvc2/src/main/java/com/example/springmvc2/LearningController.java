package com.example.springmvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/learning")
public class LearningController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/spring")
    public String springPage() {
        return "spring";
    }

    @RequestMapping("/springmvc")
    public String springMVCPage() {
        return "springmvc";
    }
}