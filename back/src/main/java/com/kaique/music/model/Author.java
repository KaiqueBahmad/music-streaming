package com.kaique.music.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Table(name = "authors")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column()
    private String name;
    
    
    @ManyToMany( mappedBy = "authors" )
    private Set<Music> musics;
	
	public Author() {
	
	}

	public Author(String name) {
		this.name = name;
		this.musics = new HashSet<>();
	}
	
	public Author(String name, Set<Music> musics) {
		this.name = name;
		this.musics = musics;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
	
	
    
}
