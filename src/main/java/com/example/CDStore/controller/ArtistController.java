package com.example.CDStore.controller;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.service.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController()
@RequestMapping("artist")
public class ArtistController {

    //validations
    //@Valid,@NotNull,@AssertTrue,@Size,@Min,@Max,@NotEmpty,@NotBlank,@Positive,@PositiveOrZero,@Past,@Present,@Future

    private IArtistService artistService;

    public ArtistController(IArtistService artistService) {
        this.artistService = artistService;
    }


    @PostMapping("/create")
    public ResponseEntity<ArtistDto> createArtist(@RequestBody @Valid ArtistDto artistDto) {
        return new ResponseEntity<>(artistService.createArtist(artistDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @GetMapping("/byname")
    public ResponseEntity<List<ArtistDto>> getArtistsByName(@RequestParam @NotNull String name) {
        return new ResponseEntity<>(artistService.getArtistsByName(name), HttpStatus.OK);
    }

    @GetMapping("/cds")
    public ResponseEntity<List<CDDto>> getCDsOfArtist(@RequestParam @NotNull String artist) {
        return new ResponseEntity<>(artistService.getCDsOfArtist(artist), HttpStatus.OK);
    }

    @GetMapping("/songs")
    public ResponseEntity<List<SongDto>> getSongsOfArtist(@RequestParam @NotNull String artist) {
        return new ResponseEntity<>(artistService.getSongsOfArtist(artist), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<ArtistDto> replaceArtist(@RequestParam @NotNull Long id, @RequestBody @Valid  ArtistDto artist) {
        return new ResponseEntity<>(artistService.replaceArtist(id, artist), HttpStatus.OK);
    }

    @DeleteMapping("/del")
    public ResponseEntity<ArtistDto> delArtistByName(@RequestParam @NotNull Long id) {
        return new ResponseEntity<>(artistService.deleteArtistById(id), HttpStatus.OK);
    }

}
