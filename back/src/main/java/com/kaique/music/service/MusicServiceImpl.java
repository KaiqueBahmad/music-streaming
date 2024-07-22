package com.kaique.music.service;

import com.kaique.music.model.Music;
import com.kaique.music.model.Playlist;
import com.kaique.music.model.User;
import com.kaique.music.repository.MusicRepository;
import com.kaique.music.repository.PlaylistRepository;
import com.kaique.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public Iterable<Music> listAllMusics() {
        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> getMusicById(UUID id) {
        return musicRepository.findById(id);
    }

    @Override
    public boolean idIsAvaliable(UUID id) {
        return false;
    }

    @Override
    public Iterable<Music> getMusicByName(String name) {
        return null;
    }

    @Override
    public Music saveMusic(Music music) {
        return this.musicRepository.save(music);
    }

    @Override
    public Music changeMusicName(UUID id, String new_name) {
        return null;
    }

    @Override
    public void deleteMusic(UUID id) {

    }
}
