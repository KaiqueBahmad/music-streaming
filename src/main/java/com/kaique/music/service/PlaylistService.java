package com.kaique.music.service;

import com.kaique.music.model.Playlist;
import java.util.Optional;
import java.util.UUID;

public interface PlaylistService  {
    Iterable<Playlist> listAllPlaylists();
    Optional<Playlist> getPlaylistById(UUID id);
    boolean idIsAvaliable(UUID id);
    Iterable<Playlist> getPlaylistsByName(String name);
    Playlist savePlaylist(Playlist playlist);
    Playlist changePlaylistName(UUID id,String new_name);
    void deletePlaylist(UUID id);
    Playlist addMusicToPlaylist(UUID playlistId, UUID musicID);
    void removeMusicFromPlaylist(UUID playlistId, UUID musicID);
}
