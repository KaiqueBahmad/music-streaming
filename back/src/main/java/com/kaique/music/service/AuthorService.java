package com.kaique.music.service;

import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.exceptions.NameAlreadyTaken;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;
import com.kaique.music.repository.AuthorRepository;
import com.kaique.music.repository.MusicRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private MusicRepository musicRepository;
    
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

    @Transactional
    public void createAuthorsAndMusics() {
    	Author artist1 = new Author("Taylor Swift");
        Author artist2 = new Author("Ed Sheeran");
        Author artist3 = new Author("Adele");
        Author artist4 = new Author("Drake");
        Author artist5 = new Author("Billie Eilish");

        authorRepository.save(artist1);
        authorRepository.save(artist2);
        authorRepository.save(artist3);
        authorRepository.save(artist4);
        authorRepository.save(artist5);

        Set<Author> authorsForMusic1 = new HashSet<>();
        authorsForMusic1.add(artist1);
        authorsForMusic1.add(artist2);

        Set<Author> authorsForMusic2 = new HashSet<>();
        authorsForMusic2.add(artist2);
        authorsForMusic2.add(artist3);

        Set<Author> authorsForMusic3 = new HashSet<>();
        authorsForMusic3.add(artist3);
        authorsForMusic3.add(artist4);

        Set<Author> authorsForMusic4 = new HashSet<>();
        authorsForMusic4.add(artist4);
        authorsForMusic4.add(artist5);

        Set<Author> authorsForMusic5 = new HashSet<>();
        authorsForMusic5.add(artist5);
        authorsForMusic5.add(artist1);

        Music music1 = new Music("Love Story", authorsForMusic1, "coverURL1", "musicPath1");
        Music music2 = new Music("Shape of You", authorsForMusic2, "coverURL2", "musicPath2");
        Music music3 = new Music("Hello", authorsForMusic3, "coverURL3", "musicPath3");
        Music music4 = new Music("Hotline Bling", authorsForMusic4, "coverURL4", "musicPath4");
        Music music5 = new Music("Bad Guy", authorsForMusic5, "coverURL5", "musicPath5");

        Music music6 = new Music("Blank Space", authorsForMusic1, "coverURL6", "musicPath6");
        Music music7 = new Music("Castle on the Hill", authorsForMusic2, "coverURL7", "musicPath7");
        Music music8 = new Music("Someone Like You", authorsForMusic3, "coverURL8", "musicPath8");
        Music music9 = new Music("God's Plan", authorsForMusic4, "coverURL9", "musicPath9");
        Music music10 = new Music("Everything I Wanted", authorsForMusic5, "coverURL10", "musicPath10");

        musicRepository.save(music1);
        musicRepository.save(music2);
        musicRepository.save(music3);
        musicRepository.save(music4);
        musicRepository.save(music5);
        musicRepository.save(music6);
        musicRepository.save(music7);
        musicRepository.save(music8);
        musicRepository.save(music9);
        musicRepository.save(music10);
    }
    
    
    public void deleteAuthor(UUID id) throws IdNotFound {
        Optional<Author> authorResp = authorRepository.findById(id);
        if (authorResp.isEmpty()) {
            throw new IdNotFound(id.toString());
        }
        authorRepository.deleteById(id);
    }
}
