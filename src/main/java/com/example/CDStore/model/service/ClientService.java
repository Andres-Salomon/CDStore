package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.ClientDto;
import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.Client;
import com.example.CDStore.repository.IArtistRepository;
import com.example.CDStore.repository.IClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    private IClientRepository clientRepository;
    private ModelMapper mapper;

    ClientService(IClientRepository clientRepository,ModelMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper=mapper;
    }



    @Override
    public ClientDto createClient(ClientDto clientDto) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
             date=sdf.parse(clientDto.getDob());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Client client= new Client(clientDto.getFirstName(),clientDto.getLastName(),date);
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients=clientRepository.findAllClients();
        return clients.stream().map(client->mapper.map(client,ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client=clientRepository.findClientById(id);
        ClientDto clientDto=mapper.map(client,ClientDto.class);
        return clientDto;
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        clientRepository.updateClient(id,clientDto.getFirstName(),
                clientDto.getLastName(),clientDto.getDob(),
                clientDto.getAddress(),clientDto.getZipCode());
        return clientDto;
    }


    @Override
    public ClientDto delClientById(Long id) {
        Client client=clientRepository.findClientById(id);
        clientRepository.delClient(id);
        ClientDto clientDto=mapper.map(client,ClientDto.class);
        return clientDto;
    }
}
