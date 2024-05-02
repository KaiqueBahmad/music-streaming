package com.kaique.music.controller;

import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRepresentation;
import com.kaique.music.service.AuthorServiceImpl;
import com.kaique.music.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping({"/author"})
public class AuthorController {
    @Autowired
    private AuthorServiceImpl authorService;

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
}
