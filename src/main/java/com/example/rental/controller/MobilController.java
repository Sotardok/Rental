package com.example.rental.controller;

import com.example.rental.entity.Mobil;
import com.example.rental.repository.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mobil/")
public class MobilController {

    @Autowired
    private MobilRepository mobilRepository;

    @GetMapping("showForm")
    public String showForm(Mobil mobil) {
        return "add-mobil";
    }

    @PostMapping("add")
    public String add(@Valid Mobil mobil, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-mobil";
        }
        this.mobilRepository.save(mobil);
        return "redirect:list";
    }

    @GetMapping("list")
    public String students(Model model) {
        model.addAttribute("mobil", this.mobilRepository.findAll());
        return "mobil-view";
    }

}
