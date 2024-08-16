package com.kaique.music.model;

import com.kaique.music.exceptions.IdNotFound;
import com.kaique.music.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;
import java.util.UUID;

public class MusicRepresentation {

//    @Autowired
//    private AuthorServiceImpl authorService;

    public MusicRepresentation(Music source) {
        this.name  = source.getName();
        this.coverURL = source.getCoverURL();
//        this.authors = new String[source.getAuthorIDS().size()];
//        int count = 0;
//        for (String id:source.getAuthorIDS()) {
//            try {
//                authors[count++] = authorService.getAuthorById(UUID.fromString(id)).get().getName();
//            } catch (IdNotFound e) {
//                authors[count-1] = "not-found";
//            }
//        }
    }

    public MusicRepresentation() {

    }
    String name;
//    String[] authorsIds;
//    String[] authors;
    public String getName() {
        return name;
    }

    public String getCoverURL() {
        return coverURL;
    }
//
//    public String[] authors() {
//        return this.authors;
//    }

    String coverURL;
}
