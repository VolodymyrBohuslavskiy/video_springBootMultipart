package com.example.springbootmultipart.Services;

import com.example.springbootmultipart.DAO.ContactDAO;
import com.example.springbootmultipart.models.Contact;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
