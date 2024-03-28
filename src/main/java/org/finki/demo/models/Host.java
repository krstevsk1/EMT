package org.finki.demo.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this. surname = surname;
        this.country = country;
    }
}
