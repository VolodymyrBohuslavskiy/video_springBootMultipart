package com.example.springbootmultipart.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "tels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String img;
    @Size(min = 3, max = 8, message = "Hello {foo.mas}")
    String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contact")
    List<Tel> tels;

    public Contact(String img, @Size(min = 3, max = 8, message = "Hello {foo.mas}") String name) {
        this.img = img;
        this.name = name;
    }

    public Contact() {
    }
}
