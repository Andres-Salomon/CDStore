package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.Song;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "artist_song")
public class ArtistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "song_id")
    private Song song;


}
