package com.paragonitfeni.main.RestController.Backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class Dashboard {
    @GetMapping("/")
    public String home(){
        return "dashboard.html";
    }


}
