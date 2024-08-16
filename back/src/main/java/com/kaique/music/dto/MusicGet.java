package com.kaique.music.dto;

import java.util.ArrayList;
import java.util.List;

import com.kaique.music.model.Author;
import com.kaique.music.model.Music;

public class MusicGet {
	private String name = "";
	private String imagePath = "";
	private String author = "";
	
	
	public MusicGet(Music music) {
		this.name 		= music.getName();
		this.imagePath 	= music.getCoverURL();
		String[] authorsNameList =  new String[music.getAuthors().size()];
		List<Author> authors = new ArrayList<Author>(music.getAuthors()); 
		int i = 0;
		while (i < authorsNameList.length) {
			authorsNameList[i] = authors.get(i).getName();
			i++;
		}
		this.author = String.join(", ", authorsNameList);
		System.out.println(this.author);
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
