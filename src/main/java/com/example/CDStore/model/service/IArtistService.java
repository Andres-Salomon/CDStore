package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;

import java.util.List;

public interface IArtistService {


    ArtistDto createArtist(ArtistDto artist);
    List<ArtistDto> getAllArtists();

    List<ArtistDto> getArtistsByName(String name);

    ArtistDto replaceArtist(Long id,ArtistDto artist);

    ArtistDto deleteArtistById(Long id);

    List<CDDto> getCDsOfArtist(String artist);

    List<SongDto> getSongsOfArtist(String artist);
}
