package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Song;

import javax.persistence.*;

@Entity
@Table(name = "song_cd")
public class SongCD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cd_id")
    private CD cd;

}
