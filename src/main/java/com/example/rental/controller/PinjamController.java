package com.example.rental.controller;

import com.example.rental.entity.Kembalikan;
import com.example.rental.entity.Mobil;
import com.example.rental.entity.Pinjam;
import com.example.rental.entity.Student;
import com.example.rental.repository.KembalikanRepository;
import com.example.rental.repository.MobilRepository;
import com.example.rental.repository.PinjamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/pinjam/")
public class PinjamController {
    @Autowired
    private PinjamRepository pinjamRepository;

    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private KembalikanRepository kembalikanRepository;

    @GetMapping("showForm/{id}")
    public String showForm(@PathVariable("id") long id, Model model, Pinjam pinjam) {
        Mobil mobil = this.mobilRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid mobil id : " + id));
        model.addAttribute("mobil",mobil);
        return "add-pinjam";
    }

    @PostMapping("add/{id}")
    public String add(@Valid Pinjam pinjam,@PathVariable ("id") int id, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-pinjam";
        }
        pinjam.setMobil_id(id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        pinjam.setDate(dtf.format(now));
        this.pinjamRepository.save(pinjam);
        return "redirect:/pinjam/list";
    }
    @GetMapping("kembalikan/list")
    public String students(Model model) {
        model.addAttribute("kembalikan", this.kembalikanRepository.findAll());
        return "kembalikan-view";
    }
    @GetMapping("list")
    public String pinjam(Model model) {
        model.addAttribute("pinjam", this.pinjamRepository.findAll());
        return "pinjam-view";
    }

    @GetMapping("kembalikan/{id}")
    public String kembalikan(@Valid Kembalikan kembalikan, @PathVariable ("id") Long id, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-pinjam";
        }
        Pinjam pinjam1 = this.pinjamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pinjam id : " + id));
        Mobil mobil = this.mobilRepository.findById((long) pinjam1.getMobil_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid mobil id : " + id));
        Kembalikan kembalikan1 = new Kembalikan();
        kembalikan1.setHarga(mobil.getHarga());
        kembalikan1.setPinjamId(Math.toIntExact(id));
        kembalikan1.setPeminjam(pinjam1.getNama());
        kembalikan1.setNIK(pinjam1.getNIK());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        kembalikan1.setDate(dtf.format(now));

        kembalikanRepository.save(kembalikan1);
        pinjamRepository.deleteById(id);
        return "redirect:/pinjam/kembalikan/list";
    }
}
