 package com.kaique.music.controller;

import com.kaique.music.dto.MusicGet;
import com.kaique.music.model.Music;
import com.kaique.music.model.MusicRepresentation;
import com.kaique.music.model.PlaylistRepresentation;
import com.kaique.music.repository.MusicRepository;
import com.kaique.music.service.MusicService;
import org.apache.coyote.Response;
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
    private MusicService musicService;
    @Autowired
    private MusicRepository repo;

    @GetMapping("/featured")
    public ResponseEntity<List<MusicGet>> featuredSongs() {
        // I should make a query for this operation
        List<Music> allMusics = repo.findAll();
        ArrayList<MusicGet> featured = new ArrayList<>();
        allMusics.sort(new Comparator<Music>() {
            @Override
            public int compare(Music m1, Music m2) {
                return Long.compare( m2.getViews(), m1.getViews());
            }
        });
        int i = 0;
        while (i < 10 && i < allMusics.size()) {
        	featured.add(new MusicGet(allMusics.get(i)));
        	i++;
        }
        
        
        return ResponseEntity.ok(featured);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MusicRepresentation>> showAllMusics() {
        List<MusicRepresentation> musics = new ArrayList<>();

        for (Music music : this.musicService.listAllMusics()) {
            musics.add(new MusicRepresentation(music));
        }

        return ResponseEntity.ok(musics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicRepresentation> showUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        System.out.println(uid);
        Optional<Music> music_ = this.musicService.getMusicById(uid);
        System.out.println(music_.isPresent());
        if (music_.isPresent()) {
            return ResponseEntity.ok(new MusicRepresentation(music_.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
