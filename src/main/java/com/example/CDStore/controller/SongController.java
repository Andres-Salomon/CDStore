package com.example.CDStore.controller;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.ClientDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.service.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("song")
public class SongController {

    private ISongService songService;
    public SongController(ISongService songService){
        this.songService=songService;
    }
    public List<SongDto> getAllArtists(){
        List<SongDto> songs=new ArrayList<>();
        return songs;
    }

    @PostMapping("/create")
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto){
        return new ResponseEntity<>(songService.createSong(songDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SongDto>> getAllSongs(){
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @GetMapping("/bytitle")
    public ResponseEntity<List<SongDto>> getSongByTitle(@RequestParam @NotNull String title){
        return new ResponseEntity<>(songService.getSongsByTitle(title),HttpStatus.OK);
    }
    @GetMapping("/byprice")
    public ResponseEntity<List<SongDto>> getSongByPrice(@RequestParam @NotEmpty double price){
        return new ResponseEntity<>(songService.getSongByPrice(price),HttpStatus.OK);
    }
    @GetMapping("/byprice<")
    public ResponseEntity<List<SongDto>> getSongByPriceLowerThan(@RequestParam @NotEmpty double price){
        return new ResponseEntity<>(songService.getSongByPriceLowerThan(price),HttpStatus.OK);
    }
    @GetMapping("/byprice>")
    public ResponseEntity<List<SongDto>> getSongByPriceHigherThan(@RequestParam @NotEmpty double price){
        return new ResponseEntity<>(songService.getSongByPriceHigherThan(price),HttpStatus.OK);
    }
    @GetMapping("/byduration")
    public ResponseEntity<List<SongDto>> getSongByDuration(@RequestParam @NotEmpty double duration){
        return new ResponseEntity<>(songService.getSongByDuration(duration),HttpStatus.OK);
    }
    @GetMapping("/artist")
    public ResponseEntity<List<ArtistDto>> getArtistBySongId(@RequestParam @NotNull  Long id){
        return new ResponseEntity<>(songService.getArtistBySong(id),HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<SongDto> updateSong(@RequestParam @NotNull Long id, @RequestBody SongDto songDto){
        return new ResponseEntity<>(songService.updateSong(id,songDto),HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public ResponseEntity<SongDto> deleteSong(@RequestParam @NotNull  Long id){
        return new ResponseEntity<>(songService.deleteSong(id),HttpStatus.OK);
    }

}
