package com.myapp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.pma.dao.UserAccountRepository;
import com.myapp.pma.entities.UserAccount;

@Controller
public class SecurityController {
    
    @Autowired
    UserAccountRepository userRepo;

    @Autowired
    BCryptPasswordEncoder bEncoder;

    //가입하기 화면
    @GetMapping("/register")
    public String register(Model model) {
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount user) {
        user.setPassword(bEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/";
    }
}
