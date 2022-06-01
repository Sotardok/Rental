package com.example.rental.controller;

import com.example.rental.entity.Pinjam;
import com.example.rental.entity.Student;
import com.example.rental.repository.MobilRepository;
import com.example.rental.repository.PinjamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pinjam/")
public class PinjamController {
    @Autowired
    private PinjamRepository pinjamRepository;

    @GetMapping("showForm")
    public String showStudentForm(Pinjam pinjam) {
        return "add-pinjam";
    }
}
