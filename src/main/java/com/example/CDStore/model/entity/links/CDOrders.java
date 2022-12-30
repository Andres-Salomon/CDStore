package com.example.CDStore.model.entity.links;

import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Orders;

import javax.persistence.*;

@Entity
@Table(name = "cd_orders")
public class CDOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cd_id")
    private CD cd;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "orders_id")
    private Orders orders;

}
