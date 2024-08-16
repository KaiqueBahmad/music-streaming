package com.kaique.music.service;

import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.exceptions.NameAlreadyTaken;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;
import com.kaique.music.repository.AuthorRepository;
import com.kaique.music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    
    public Iterable<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    
    public Optional<Author> getAuthorById(UUID id) throws IdNotFound {
        return authorRepository.findById(id);
    }

    
    public boolean idIsAvaliable(UUID id) {
        return authorRepository.findById(id).isEmpty();
    }

    
    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    
    public Author changeAuthorName(UUID id, String new_name) throws IdNotFound, NameAlreadyTaken {
        if (authorRepository.findByName(new_name).isPresent()) {
            throw new NameAlreadyTaken(new_name);
        }
        Optional<Author> authorResp = authorRepository.findById(id);
        if (authorResp.isEmpty()) {
            throw new IdNotFound(id.toString());
        }
        Author author = authorResp.get();
        author.setName(new_name);
        return authorRepository.save(author);
    }

    
    public void deleteAuthor(UUID id) throws IdNotFound {
        Optional<Author> authorResp = authorRepository.findById(id);
        if (authorResp.isEmpty()) {
            throw new IdNotFound(id.toString());
        }
        authorRepository.deleteById(id);
    }
}
