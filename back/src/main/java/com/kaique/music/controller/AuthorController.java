package com.kaique.music.controller;

import com.kaique.music.dto.AuthorGet;
import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRepresentation;
import com.kaique.music.service.AuthorService;
import com.kaique.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping({"/author"})
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> showUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        Optional<Author> authorResp = null;
        try {
            authorResp = authorService.getAuthorById(UUID.fromString(id));
            return ResponseEntity.ok(authorResp.get());
        } catch (IdNotFound e) {
            throw new RuntimeException(e);
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AuthorGet>> showAllUsers() {
    	List<AuthorGet> authors = new ArrayList<>();
    	
    	this.authorService.listAllAuthors().forEach(
			(Author author) -> {
				authors.add(new AuthorGet(author));
			}
		);
    	
    	
    	return ResponseEntity.ok(authors);
    }
    
    @GetMapping("/populate")
    public ResponseEntity<String> populate(){
    	
    	authorService.createAuthorsAndMusics();
    	
    	return ResponseEntity.ok("Banco de dados populado com autores e musicas");
    }
    
}
