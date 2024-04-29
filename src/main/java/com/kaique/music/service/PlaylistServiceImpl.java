package com.kaique.music.service;
import com.kaique.music.model.Playlist;
import com.kaique.music.model.User;
import com.kaique.music.repository.PlaylistRepository;
import com.kaique.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Override;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<Playlist> listAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> getPlaylistById(UUID id) {
        return playlistRepository.findById(id);
    }

    @Override
    public boolean idIsAvaliable(UUID id) {
        return !playlistRepository.existsById(id);
    }

    @Override
    public Iterable<Playlist> getPlaylistsByName(String name) {
        return playlistRepository.findAllByName(name);
    }

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist changePlaylistName(UUID id, String new_name) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (playlist.isPresent()) {
            playlist.get().setName(new_name);
            return playlistRepository.save(playlist.get());
        }
        return null;
    }

    @Override
    public void deletePlaylist(UUID id) {
        for (User usr: userRepository.findAll()) {
            if (usr.havePlaylist(id)) {
                usr.removePLaylist(id);
            }
        }
        playlistRepository.deleteById(id);
    }

    @Override
    public Playlist addMusicToPlaylist(UUID playlistId, UUID musicID) {
        Optional<Playlist> playlist_ = playlistRepository.findById(playlistId);
        if (playlist_.isPresent()) {
            Playlist playlist = playlist_.get();
            playlist.addMusic(musicID);
            return playlistRepository.save(playlist);
        }
        return null;
    }

    @Override
    public void removeMusicFromPlaylist(UUID playlistId, UUID musicID) {
        Optional<Playlist> playlist_ = playlistRepository.findById(playlistId);
        if (playlist_.isPresent()) {
            Playlist playlist = playlist_.get();
            playlist.removeMusic(musicID);
            playlistRepository.save(playlist);
        }
    }
}
