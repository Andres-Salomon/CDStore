package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ClientDto;

import java.util.List;

public interface IClientService {
    ClientDto delClientById(Long id);

    List<ClientDto> getAllClients();

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(Long id);

    ClientDto updateClient(Long id, ClientDto clientDto);
}
