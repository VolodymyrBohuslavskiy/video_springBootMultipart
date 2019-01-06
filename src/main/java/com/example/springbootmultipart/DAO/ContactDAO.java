package com.example.springbootmultipart.DAO;

import com.example.springbootmultipart.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO extends JpaRepository<Contact,Integer > {
}
