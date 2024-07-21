package com.kaique.music.controller;

import com.kaique.music.model.*;
import com.kaique.music.service.PlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping({"/playlists"})
public class PlaylistController {
    @Autowired
    private PlaylistServiceImpl playlistService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> showUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        System.out.println(uid);
        Optional<Playlist> playlist_ = this.playlistService.getPlaylistById(uid);
        if (playlist_.isPresent()) {
            return ResponseEntity.ok(new PlaylistRepresentation(playlist_.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
