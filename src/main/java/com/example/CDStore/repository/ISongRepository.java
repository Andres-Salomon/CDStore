package com.example.CDStore.repository;

import com.example.CDStore.model.entity.Artist;

import com.example.CDStore.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
    @Query("FROM Song")
    List<Song> findAllSong();

    @Query("FROM Song S WHERE S.id=:id")
    Song findSongById(Long id);
    @Query("FROM Song S WHERE S.title=:title")
    List<Song> findSongByTitle(String title);
    @Query("FROM Song S WHERE S.price=:price")
    List<Song> findSongByPrice(double price);
    @Query("FROM Song S WHERE S.price<:price")
    List<Song> findSongByPriceLowerThan(double price);
    @Query("FROM Song S WHERE S.price>:price")
    List<Song> findSongByPriceHigherThan(double price);
    @Query("FROM Song S WHERE S.duration=:duration")
    List<Song> findSongByDuration(double duration);
    @Query("SELECT A FROM Song S " +
            "JOIN ArtistSong SA on S.id=song_id " +
            "JOIN Artist A on A.id=artist_id where S.id=:id")
    List<Artist> findArtistBySongId(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Song S " +
            "SET S.title=:title, " +
            "S.price=:price, " +
            "S.duration=:duration " +
            "WHERE S.id=:id")
    void updateSong(Long id,String title, double price, double duration);

    @Transactional
    @Modifying
    @Query("DELETE Song S WHERE S.id=:id")
    void delSong(Long id);

}
