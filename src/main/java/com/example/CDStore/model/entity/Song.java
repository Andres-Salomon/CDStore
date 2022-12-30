package com.example.CDStore.model.entity;

import com.example.CDStore.model.entity.links.ArtistSong;
import com.example.CDStore.model.entity.links.OrdersClient;
import com.example.CDStore.model.entity.links.SongCD;
import com.example.CDStore.model.entity.links.SongOrders;
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
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long songId;

    @Column(name="title")
    private String title;
    @Column(name = "duration")
    private double duration;
    @Column(name="price")
    private double price;

    @OneToMany(mappedBy = "orders",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<SongOrders> songOrders = new HashSet<>();

    @OneToMany(mappedBy = "cd",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<SongCD> songCDS = new HashSet<>();

    @OneToMany(mappedBy = "song",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<ArtistSong> artistSongs = new HashSet<>();

    public Song(String title, int price, double duration) {
        this.title=title;
        this.price=price;
        this.duration=duration;
    }

    //Song must have a list of artist that participated;
}
