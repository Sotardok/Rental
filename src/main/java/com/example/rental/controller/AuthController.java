package com.example.rental.controller;

import com.example.rental.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/")
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;


}
