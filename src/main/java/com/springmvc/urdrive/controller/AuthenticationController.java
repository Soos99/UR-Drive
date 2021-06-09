package com.springmvc.urdrive.controller;

import com.springmvc.urdrive.model.Student;
import com.springmvc.urdrive.service.StudentService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
public class AuthenticationController {
    private final StudentService studentService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignUp(@ModelAttribute Student student, Model model, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("signupError", errors.toString());
            return "signup";
        }
        studentService.createStudent(student);
        model.addAttribute("signupSuccess", true);
        return "signup";
    }
}