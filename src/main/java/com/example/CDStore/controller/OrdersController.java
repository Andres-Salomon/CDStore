package com.example.CDStore.controller;

import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.ClientDto;
import com.example.CDStore.model.dtos.OrdersDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.service.IOrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController {

    private IOrdersService ordersService;

    public OrdersController(IOrdersService ordersService){
        this.ordersService=ordersService;
    }
    @GetMapping("/all/client")
    public ResponseEntity<List<OrdersDto>> getAllOrdersOfClient(@RequestParam @NotNull Long client) {
        return new ResponseEntity<>(ordersService.getOrdersOfClient(client), HttpStatus.OK);
    }

    @GetMapping("/byid")
    public ResponseEntity<OrdersDto> getOrderById(@RequestParam @NotNull Long id) {
        return new ResponseEntity<>(ordersService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<List<SongDto>> getAllSongOfOrderId(@RequestParam @NotNull Long order) {
        return new ResponseEntity<>(ordersService.getSongsOfOrder(order),HttpStatus.OK);
    }

    @GetMapping("/cd")
    public ResponseEntity<List<CDDto>> getAllCDOfOrderId(@RequestParam @NotNull Long order) {
        return new ResponseEntity<>(ordersService.getCDOfOrder(order),HttpStatus.OK);
    }


}
