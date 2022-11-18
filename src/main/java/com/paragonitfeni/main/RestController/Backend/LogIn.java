package com.paragonitfeni.main.RestController.Backend;

import com.paragonitfeni.main.Model.DB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
public class LogIn {

    @GetMapping()
    public String home() {
        if (DB.AUTHENTICATION) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";

    }
}
