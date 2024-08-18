package com.kaique.music.dto;

import java.util.List;

import com.kaique.music.model.Author;
import com.kaique.music.model.Music;

public class AuthorGet {
	
	public AuthorGet(Author author) {
		this.name = author.getName();
		MusicGet[] musics = new MusicGet[author.getMusics().size()];
		int i = 0;
		for (Music music: author.getMusics()) {
			musics[i++] = new MusicGet(music);
		}
		this.musics = musics;
	}
	
	private String name;
	private MusicGet[] musics;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MusicGet[] getMusics() {
		return musics;
	}
	public void setMusics(MusicGet[] musics) {
		this.musics = musics;
	}
	
	
	
	
}
