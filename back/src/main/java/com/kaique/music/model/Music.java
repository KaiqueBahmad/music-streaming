package com.kaique.music.model;


import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table(name = "musics")
@Entity
public class Music {
    public Music() {

    }

    public Music(String name, Collection<Author> authors, String coverURL, String musicPath) {
        this.name 		= name;
        this.coverURL 	= coverURL;
        this.musicPath 	= musicPath;
        this.authors 	= new HashSet<Author>(authors); 
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
	@ManyToMany
	private Set<Author> authors;

    public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	private String name;


    private String coverURL;
    private String musicPath;
    private Long views = 0L;

    public UUID getId() {
        return id;
    }
    public void blankId() {
        this.id = null;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getViews() {
        return views;
    }
}
