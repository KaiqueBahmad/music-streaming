package com.kaique.music.controller;

import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRepresentation;
import com.kaique.music.model.PlaylistRepresentation;
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
@RequestMapping({"/music"})
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> showUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        System.out.println(uid);
        Optional<Music> music_ = this.musicService.getMusicById(uid);
        if (music_.isPresent()) {
            return ResponseEntity.ok(new MusicRepresentation(music_.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
