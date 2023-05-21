package com.geekster.MusicStreaming.repo;

import com.geekster.MusicStreaming.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {

    List<Song> findBySongNameAndGenre(String name , String genre);

    List<Song> findBySongName(String name);

    List<Song> findByGenre(String genre);
}
