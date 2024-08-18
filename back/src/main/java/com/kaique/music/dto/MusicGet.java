package com.kaique.music.dto;

import java.util.ArrayList;
import java.util.List;

import com.kaique.music.model.Author;
import com.kaique.music.model.Music;

public class MusicGet {
	private String name = "";
	private String coverPath = "";
	private String authors = "";
	
	
	public MusicGet(Music music) {
		this.name 		= music.getName();
		this.coverPath 	= music.getCoverURL();
		String[] authorsNameList =  new String[music.getAuthors().size()];
		List<Author> authors = new ArrayList<Author>(music.getAuthors()); 
		int i = 0;
		while (i < authorsNameList.length) {
			authorsNameList[i] = authors.get(i).getName();
			i++;
		}
		this.authors = String.join(", ", authorsNameList);
		System.out.println(this.authors);
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoverPath() {
		return coverPath;
	}
	public void setCoverPath(String imagePath) {
		this.coverPath = imagePath;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String author) {
		this.authors = author;
	}
	
	
	
}
