package com.example.CDStore.repository;

import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Orders;
import com.example.CDStore.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {

    //SELECT Orders FROM Client WHERE Client.id=:id
    @Query("FROM Orders o WHERE o.id=:id")
    List<Orders> ordersByClient(Long id);
    @Query("SELECT o FROM Orders o WHERE o.id=:id")
    Orders orderById(Long id);
    @Query("From Orders")
    List<Song> songOfOrders(Long id);
    @Query("From Song")
    List<CD> cdOfOrders(Long id);
}
