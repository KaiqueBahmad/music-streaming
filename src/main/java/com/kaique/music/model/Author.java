package com.kaique.music.model;
import jakarta.persistence.*;

import java.util.UUID;


@Table(name = "authors")
@Entity
public class Author {
    public Author() {
    }

    public Author(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String nome;
    private Long views = 0L;

    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
