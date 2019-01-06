package com.example.springbootmultipart.Services;

import com.example.springbootmultipart.DAO.ContactDAO;
import com.example.springbootmultipart.models.Contact;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    ContactDAO contactDAO;

    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    public List<Contact> showAll() {
        List<Contact> list = contactDAO.findAll(Sort.by("id"));
        Collections.reverse(list);
        return list;
    }


    public void transferFile(MultipartFile img) throws IOException {
        String path = "E:\\IdeaProjects\\Advanced_Java\\video spring boot multipart\\src\\main\\resources\\static";
        img.transferTo(new File(path, img.getOriginalFilename()));

    }
}
