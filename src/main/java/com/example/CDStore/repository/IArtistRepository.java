package com.example.CDStore.repository;

import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IArtistRepository extends JpaRepository<Artist,Long> {
    @Query("FROM Artist")
    List<Artist> findAllArtists();

    @Query("FROM Artist A WHERE A.name LIKE :name")
    List<Artist> findArtistsByName(String name);

    @Query("SELECT CD FROM Artist A " +
            "JOIN CDArtist CA on A.id=artist_id " +
            "JOIN CD CD on CD.id=cd_id where A.name LIKE :artist")
    List<CD> findCDsOfArtist(String artist);

    @Query("SELECT S FROM Artist A " +
            "JOIN ArtistSong SA on A.id=artist_id " +
            "JOIN Song S on S.id=song_id where A.name LIKE :artist")
    List<Song> findSongsOfArtist(String artist);

    @Query("FROM Artist A WHERE A.id=:id")
    Artist findArtistById(Long id);

    //Both @Transactional and @Modifying are required for update and delete.
    @Transactional
    @Modifying
    @Query("UPDATE Artist A SET A.name=:name WHERE A.id=:id")
    void putArtist(Long id,String name);


    @Transactional
    @Modifying
    @Query("DELETE Artist A WHERE A.id=:id")
    void deleteArtistById(Long id);


}
