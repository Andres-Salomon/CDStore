package com.example.CDStore.repository;

import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {
    @Query("FROM Client")
    List<Client> findAllClients();

    @Query("FROM Client C WHERE C.id=:id")
    Client findClientById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Client C " +
            "SET C.firstName=:firstName, " +
            "C.lastName=:lastName, " +
            "C.dob=:date, " +
            "C.address=:address, " +
            "C.zipCode=:zipcode " +
            "WHERE C.id=:id")
    void updateClient(Long id,String firstName, String lastName, String date, String address, String zipcode);

    @Transactional
    @Modifying
    @Query("DELETE Client C WHERE C.id=:id")
    void delClient(Long id);


}
