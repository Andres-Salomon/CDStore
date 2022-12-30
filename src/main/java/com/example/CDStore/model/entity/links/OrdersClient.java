package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.Client;
import com.example.CDStore.model.entity.Orders;

import javax.persistence.*;

@Entity
@Table(name = "orders_client")
public class OrdersClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client_id")
    private Client client;
}
