package com.example.CDStore.model.entity;

import com.example.CDStore.model.entity.links.CDArtist;
import com.example.CDStore.model.entity.links.CDOrders;
import com.example.CDStore.model.entity.links.SongCD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cd")
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long cdId;
    @Column(name = "title")
    private String title;
    @Column(name="price")
    private double price;

    @Column(name="year")
    private int year;

    @OneToMany(mappedBy = "cd",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<CDArtist> cdArtist = new HashSet<>();

    @OneToMany(mappedBy = "orders",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<CDOrders> cdOrders = new HashSet<>();

    @OneToMany(mappedBy = "cd",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<SongCD> songCDS = new HashSet<>();

    public CD(String title, int year,double price) {
        this.title=title;
        this.year=year;
        this.price=price;
    }


    //CD must have a list of songs

}
