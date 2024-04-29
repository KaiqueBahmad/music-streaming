package com.kaique.music.repository;
import com.kaique.music.model.Music;
import com.kaique.music.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {
    Optional<Music> findByName(String name);
    Iterable<Music> findAllByName(String name);
}
