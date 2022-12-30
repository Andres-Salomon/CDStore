package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.Client;
import com.example.CDStore.model.entity.Orders;
import com.example.CDStore.model.entity.Song;

import javax.persistence.*;

@Entity
@Table(name = "song_orders")
public class SongOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "orders_id")
    private Orders orders;

}
