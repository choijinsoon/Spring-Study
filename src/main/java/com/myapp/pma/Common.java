package com.myapp.pma;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Common {
    public void sharedData(Model model, Principal principal) {
        if(principal != null){
            model.addAttribute("principal", principal.getName());
        }
    }
}
