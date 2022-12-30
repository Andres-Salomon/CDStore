package com.example.CDStore.model.entity;

import com.example.CDStore.model.entity.links.CDOrders;
import com.example.CDStore.model.entity.links.OrdersClient;
import com.example.CDStore.model.entity.links.SongOrders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "cost")
    private double cost;

    @Column(name = "date")
    private Date date;


    @OneToMany(mappedBy = "client",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<OrdersClient> ordersClients = new HashSet<>();

    @OneToMany(mappedBy = "orders",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<SongOrders> songOrders = new HashSet<>();

    @OneToMany(mappedBy = "orders",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<CDOrders> cdOrders = new HashSet<>();

    //Order must have a list of songs, a list of cds, a list of clients
}
