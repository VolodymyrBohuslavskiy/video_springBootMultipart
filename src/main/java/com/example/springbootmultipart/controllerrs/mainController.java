package com.example.springbootmultipart.controllerrs;

import com.example.springbootmultipart.Services.ContactService;
import com.example.springbootmultipart.Services.TelService;
import com.example.springbootmultipart.controllerrs.editors.telEditor;
import com.example.springbootmultipart.models.Contact;
import com.example.springbootmultipart.models.Tel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

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
        model.addAttribute("fromControoler", "Titel from mainController !");
        return "index";
    }

    @PostMapping("/add")
    public String add(@Valid Contact contact, BindingResult result, @RequestParam MultipartFile img) throws IOException {
        if (result.hasErrors()) {
            System.out.println("hasErrors !!!");
        }

        contactService.transferFile(img);
        contact.setImg(img.getOriginalFilename());

        contactService.save(contact);
        System.out.println(contact.getTels());
        return "redirect:/";
    }

    // BINDERS
    @Autowired
    private telEditor telEditor;

    @InitBinder("contact")
    public void initBinder(WebDataBinder binder) {
        System.out.println("WebDataBinder");
        binder.registerCustomEditor(Tel.class, telEditor);
    }

}
