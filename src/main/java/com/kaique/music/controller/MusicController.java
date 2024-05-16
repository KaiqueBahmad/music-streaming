package com.kaique.music.controller;

import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRepresentation;
import com.kaique.music.model.PlaylistRepresentation;
import com.kaique.music.repository.MusicRepository;
import com.kaique.music.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping({"/music"})
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;
    @Autowired
    private MusicRepository repo;

    @GetMapping("/featured")
    public ResponseEntity<MusicRepresentation[]> featuredSongs(@PathVariable(value = "5", required = false) Integer limit) {
        // I should make a query for this operation
//        Iterable<Music> musicsIterator = musicService.listAllMusics();
        Iterable<Music> musicsIterator = repo.findAll();
        ArrayList<Music> musics = new ArrayList<>();
        for (Music music:musicsIterator) {
            musics.add(music);
        }
        musics.sort(new Comparator<Music>() {
            @Override
            public int compare(Music m1, Music m2) {
                return Long.compare(m1.getViews(), m2.getViews());
            }
        });
        MusicRepresentation[] featured;
        if (limit < musics.size()) {
            featured = new MusicRepresentation[limit];
        } else {
            featured = new MusicRepresentation[musics.size()];
        }
        for (int i = musics.size() - 1; i >=musics.size() - 6 ; i--) {
            featured[i] = new MusicRepresentation(musics.get(i));
        }
        return ResponseEntity.ok(featured);
    }

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
