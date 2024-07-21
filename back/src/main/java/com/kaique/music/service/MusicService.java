package com.kaique.music.service;

import com.kaique.music.model.Music;
import com.kaique.music.model.Playlist;

import java.util.Optional;
import java.util.UUID;

public interface MusicService {
    Iterable<Music> listAllMusics();
    Optional<Music> getMusicById(UUID id);
    boolean idIsAvaliable(UUID id);
    Iterable<Music> getMusicByName(String name);
    Music saveMusic(Music music);
    Music changeMusicName(UUID id,String new_name);
    void deleteMusic(UUID id);
}
