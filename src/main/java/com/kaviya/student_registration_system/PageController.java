package com.kaviya.student_registration_system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupPage()
    {
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage()
    {
        return "dashboard";
    }

    @GetMapping("/courses-page")
    public String coursesPage()
    {
        return "courses";
    }
}