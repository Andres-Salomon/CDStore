package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.OrdersDto;
import com.example.CDStore.model.dtos.SongDto;

import java.util.List;

public interface IOrdersService {
    List<OrdersDto> getOrdersOfClient(Long client);

    OrdersDto getOrderById(Long id);

    List<SongDto> getSongsOfOrder(Long order);

    List<CDDto> getCDOfOrder(Long order);
}
