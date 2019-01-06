package com.example.springbootmultipart.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "contact")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Contact contact;

    public Tel() {
    }


    public Tel(String number) {
        this.number = number;
    }
}
