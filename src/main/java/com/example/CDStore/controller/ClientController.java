package com.example.CDStore.controller;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.ClientDto;
import com.example.CDStore.model.service.ClientService;
import com.example.CDStore.model.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private IClientService clientService;
    public ClientController(IClientService clientService){
        this.clientService=clientService;
    }

    @PostMapping("create")
    public ResponseEntity<ClientDto> createClient(@RequestBody @Valid ClientDto clientDto){
        return new ResponseEntity<>(clientService.createClient(clientDto),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients(){
    return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/byid")
    public ResponseEntity<ClientDto> getClientById(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<ClientDto> updateClient(@RequestParam @NotNull Long id,ClientDto clientDto){
        return new ResponseEntity<>(clientService.updateClient(id,clientDto), HttpStatus.OK);
    }

    @DeleteMapping("/delbyid")
    public ResponseEntity<ClientDto> delClientById(@RequestParam @NotNull Long id){
        return new ResponseEntity<>(clientService.delClientById(id),HttpStatus.OK);
    }


}
