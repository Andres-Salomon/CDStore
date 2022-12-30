package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.OrdersDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Orders;
import com.example.CDStore.repository.IOrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService implements IOrdersService {
    private IOrdersRepository ordersRepository;
    private ModelMapper mapper;

    public OrdersService(IOrdersRepository ordersRepository,ModelMapper mapper){
        this.ordersRepository=ordersRepository;
        this.mapper=mapper;
    }

    @Override
    public List<OrdersDto> getOrdersOfClient(Long client) {
        List<Orders> orders=ordersRepository.ordersByClient(client);
        List<OrdersDto>ordersDtos=orders.stream().map(order->mapper.map(order,OrdersDto.class)).collect(Collectors.toList());
        return ordersDtos;
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Orders order= ordersRepository.orderById(id);
        return mapper.map(order, OrdersDto.class);
    }

    @Override
    public List<SongDto> getSongsOfOrder(Long order) {
        return null;
    }

    @Override
    public List<CDDto> getCDOfOrder(Long order) {
        return null;
    }
}
