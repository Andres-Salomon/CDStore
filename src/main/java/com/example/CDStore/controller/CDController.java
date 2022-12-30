package com.example.CDStore.controller;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.service.ICDService;
import com.example.CDStore.repository.ICDRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cd")
public class CDController {

    ICDService cdService;
    public CDController(ICDService cdService){
        this.cdService=cdService;
    }

    @PostMapping("/create")
    public ResponseEntity<CDDto> createArtist(@Valid @RequestBody CDDto cdDto) {
        return new ResponseEntity<>(cdService.createCD(cdDto), HttpStatus.OK);
    }
    @GetMapping("all")
    public ResponseEntity<List<CDDto>> getAllCDs(){
        return new ResponseEntity<>(cdService.getAllCDs(),HttpStatus.OK);
    }

    @GetMapping("/bytitle")
    public ResponseEntity<List<CDDto>> getCDsByTitle(@RequestParam @NotNull String title){
        return new ResponseEntity<>(cdService.getCDsByTitle(title), HttpStatus.OK);
    }
    @GetMapping("/byyear")
    public ResponseEntity<List<CDDto>> getCDsByYear(@RequestParam @NotEmpty int year){
        return new ResponseEntity<>(cdService.getCDsByYear(year), HttpStatus.OK);
    }

    @GetMapping("/byprice")
    public ResponseEntity<List<CDDto>> getCDsByPrice(@RequestParam @NotEmpty double price){
        return new ResponseEntity<>(cdService.getCDsByPrice(price), HttpStatus.OK);
    }

    @GetMapping("/artist")
    public ResponseEntity<List<ArtistDto>> getArtistOfCD(@RequestParam @NotNull String cd) {
        return new ResponseEntity<>(cdService.getArtistOfCD(cd), HttpStatus.OK);
    }

    @GetMapping("/cd")
    public ResponseEntity<List<CDDto>> getCDofArtist(@RequestParam @NotNull String artist) {
        return new ResponseEntity<>(cdService.getCDsByArtist(artist), HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<List<SongDto>> getSongsOfCD(@RequestParam @NotNull String cd) {
        return new ResponseEntity<>(cdService.getSongsOfCD(cd), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<CDDto> replaceCD(@RequestParam @NotNull Long id, @Valid @RequestBody CDDto cd) {
        return new ResponseEntity<>(cdService.replaceCD(id, cd), HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public ResponseEntity<CDDto> getCDByTitle(@RequestParam @NotNull Long id) {
        return new ResponseEntity<>(cdService.deleteCDById(id), HttpStatus.OK);
    }

}
