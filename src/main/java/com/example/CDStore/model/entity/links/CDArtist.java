package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.CD;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
@Table(name = "cd_artist")
public class CDArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cd_id")
    private CD cd;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
