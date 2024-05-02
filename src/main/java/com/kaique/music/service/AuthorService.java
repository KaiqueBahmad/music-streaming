package com.kaique.music.service;

import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.exceptions.NameAlreadyTaken;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;

import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
    Iterable<Author> listAllAuthors();
    Optional<Author> getAuthorById(UUID id) throws IdNotFound;
    boolean idIsAvaliable(UUID id);
    Optional<Author> getAuthorByName(String name);
    Author saveAuthor(Author author);
    Author changeAuthorName(UUID id,String new_name) throws IdNotFound, NameAlreadyTaken;
    void deleteAuthor(UUID id) throws IdNotFound;
}
