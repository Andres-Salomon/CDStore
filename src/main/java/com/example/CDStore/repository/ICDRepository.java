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
public interface ICDRepository extends JpaRepository<CD,Long> {
    @Query("FROM CD")
    List<CD> findAllCDs();
    @Query("FROM CD cd WHERE cd.title LIKE :title")
    List<CD> findCDsByTitle(@Param("title")String title);

    @Query("FROM CD cd WHERE cd.year LIKE :year")
    List<CD> findCDsByYear(@Param("year")int year);
    @Query("FROM CD cd WHERE cd.price LIKE :price")
    List<CD> findCDsByPrice(@Param("price")double price);
    @Query("SELECT DISTINCT a FROM CD cd " +
            "JOIN CDArtist ca on cd.id=cd_id " +
            "JOIN Artist a on a.id=artist_id " +
            "where cd.title LIKE :cd")
    List<Artist> findArtistByCD(String cd);

    @Query("SELECT s FROM CD cd "+
            "JOIN SongCD scd on cd.id=cd_id "+
            "JOIN Song s on s.id=song_id "+
            "where cd.title LIKE :title")
    List<Song> findSongOfCD(String title);

    @Query("SELECT DISTINCT cd FROM CD cd "+
            "JOIN CDArtist cda on cd.id=cd_id "+
            "JOIN Artist a on a.id=artist_id "+
            "where a.name = :artist")
    List<CD> findCDsByArtist(String artist);

    @Transactional
    @Modifying
    @Query("UPDATE CD cd SET cd.title=:title,cd.price=:price,cd.year=:year WHERE cd.id=:id")
    void putCD(Long id,String title,int year,double price);


    @Transactional
    @Modifying
    @Query("DELETE CD cd WHERE cd.id=:id")
    void deleteCDById(Long id);



}
