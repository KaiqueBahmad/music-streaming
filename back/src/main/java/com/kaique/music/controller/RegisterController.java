package com.kaique.music.controller;


import com.kaique.music.configuration.FileStorageConfiguration;
import com.kaique.music.model.Author;
import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRegister;
import com.kaique.music.model.User;
import com.kaique.music.service.AuthorServiceImpl;
import com.kaique.music.service.MusicServiceImpl;
import com.kaique.music.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final Path fileStorageLocation;

    public RegisterController(FileStorageConfiguration fileStorageConfiguration) {
        this.fileStorageLocation = Paths.get(fileStorageConfiguration.getUploadDir())
                .toAbsolutePath().normalize();
    }

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MusicServiceImpl musicService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorServiceImpl authorService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User new_user) {
        if (!userService.idIsAvaliable(new_user.getId())) {
            new_user.blankId();
        }
        new_user.setPassword(passwordEncoder.encode(new_user.getPassword()));
        User created = this.userService.saveUser(new_user);
        URI newUserLocation = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(newUserLocation).build();
    }

    @PostMapping("/music")
    public ResponseEntity<Music> createMusic(@RequestParam("authors") String authorsString, @RequestParam("name") String musicName, @RequestParam("music-data") MultipartFile music_data, @RequestParam(required = false) Optional<MultipartFile> cover ) {
        String MusicFileName = StringUtils.cleanPath(Objects.requireNonNull(music_data.getOriginalFilename()));
        String CoverFileName;
        if (cover.isPresent()) {
            CoverFileName = StringUtils.cleanPath(Objects.requireNonNull(cover.get().getOriginalFilename()));
        } else {
            CoverFileName = "undefined";
        }

        String[] authors = authorsString.split(",");
        String[] authorList = new String[authors.length];
        System.out.println("teste");
        int count = 0;
        for (String author:authors) {
            Optional<Author> possibleAuthor = authorService.getAuthorByName(author);
            Author authorObj;
            if (possibleAuthor.isPresent()) {
                authorObj = possibleAuthor.get();
            } else {
                authorObj = authorService.saveAuthor(new Author(author));
            }
            authorList[count++] = authorObj.getId().toString();
        }
        try {
            Path musicPath = fileStorageLocation.resolve("music_data/"+MusicFileName);
            music_data.transferTo(musicPath);
            Path coverPath = fileStorageLocation.resolve("music_data/"+CoverFileName);
            if (cover.isPresent()) {
                cover.get().transferTo(coverPath);
            }
            Music new_music = new Music(musicName, authorList, coverPath.toString(), musicPath.toString());
            Music created = this.musicService.saveMusic(new_music);
            URI newMusicLocation = ServletUriComponentsBuilder.fromCurrentContextPath().path("/music/{id}").buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(newMusicLocation).build();
        } catch (IOException exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
//    @PostMapping("/music")
//    public ResponseEntity<Music> createMusic(@RequestBody MusicRegister new_music_req) {
//        Music new_music = new Music(new_music_req);
//        if (!userService.idIsAvaliable(new_music.getId())) {
//            new_music.blankId();
//        }
//        Music created = this.musicService.saveMusic(new_music);
//        URI newMusicLocation = ServletUriComponentsBuilder.fromCurrentContextPath().path("/music/{id}").buildAndExpand(created.getId()).toUri();
//        return ResponseEntity.created(newMusicLocation).build();
//    }
}
