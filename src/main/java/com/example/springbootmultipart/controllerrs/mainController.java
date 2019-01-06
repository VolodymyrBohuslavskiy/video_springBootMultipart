package com.example.springbootmultipart.controllerrs;

import com.example.springbootmultipart.Services.ContactService;
import com.example.springbootmultipart.Services.TelService;
import com.example.springbootmultipart.models.Contact;
import com.example.springbootmultipart.models.Tel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class mainController {
    private ContactService contactService;
    private TelService telService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tel", new Tel());
        model.addAttribute("contact", new Contact());
        model.addAttribute("all", contactService.showAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(Tel tel) {
        List<Tel> tels = new ArrayList<>();
        tels.add(tel);
        tel.getContact().setTels(tels);

        telService.save(tel);
        contactService.save(tel.getContact());
        return "redirect:/";
    }


}
