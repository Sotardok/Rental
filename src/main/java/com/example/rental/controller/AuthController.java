package com.example.rental.controller;

import com.example.rental.entity.Account;
import com.example.rental.entity.LoginRequest;
import com.example.rental.entity.Student;
import com.example.rental.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("")
    public String home(Account account) {
        return "home";
    }

    @GetMapping("/add-user")
    public String register(Account account) {
        return "indexx";
    }
    @GetMapping("account/list")
    public String students(Model model) {
        model.addAttribute("account", this.accountRepository.findAll());
        return "home";
    }

    @GetMapping("/log")
    public String home(Model model) {
        return "home-login";
    }

    @PostMapping("account/add")
    public String addStudent(@Valid Account account, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-student";
        }
        this.accountRepository.save(account);
        return "redirect:list";
    }
    @GetMapping("login")
    public String login(LoginRequest loginRequest) {
        return "login";
    }

    @PostMapping("login")
    public String login(@Valid Account account, BindingResult result, Model model){
        return "home-login";
    }
}
