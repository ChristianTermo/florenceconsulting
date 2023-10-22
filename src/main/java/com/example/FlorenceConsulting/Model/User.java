package com.example.FlorenceConsulting.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private  String cognome;
    @Column
    private  String mail;
    @Column
    private String indirizzo;

    public User() {
    }

    public User(String nome, String cognome, String mail, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.indirizzo = indirizzo;
    }
}
