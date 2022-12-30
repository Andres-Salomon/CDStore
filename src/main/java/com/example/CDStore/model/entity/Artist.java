package com.example.CDStore.model.entity;

import com.example.CDStore.model.entity.links.ArtistSong;
import com.example.CDStore.model.entity.links.CDArtist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="artist")
public class Artist {


    public Artist(String name) {
        this.name=name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long artistId;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "artist",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<CDArtist> cdArtist = new HashSet<>();

    @OneToMany(mappedBy = "song",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<ArtistSong> artistSongs = new HashSet<>();

}
