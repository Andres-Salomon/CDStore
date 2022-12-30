package com.example.CDStore.model.entity;

import com.example.CDStore.model.entity.links.CDArtist;
import com.example.CDStore.model.entity.links.OrdersClient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long clientId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "zipcode")
    private String zipCode;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "client",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    private Set<OrdersClient> ordersClients = new HashSet<>();

    public Client(String firstName, String lastName, Date dob) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
    }
}
