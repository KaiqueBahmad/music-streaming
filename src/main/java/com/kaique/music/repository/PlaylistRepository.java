package com.kaique.music.repository;
import com.kaique.music.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {
    Optional<Playlist> findByName(String name);
    Iterable<Playlist> findAllByName(String name);
}
