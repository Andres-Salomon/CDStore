package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.SongDto;

import java.util.List;

public interface ISongService {

    SongDto createSong(SongDto songDto);

    List<SongDto> getAllSongs();

    List<SongDto> getSongsByTitle(String title);

    List<SongDto> getSongByPrice(double price);
    List<SongDto> getSongByPriceLowerThan(double price);

    List<SongDto> getSongByPriceHigherThan(double price);

    List<SongDto> getSongByDuration(double duration);

    List<ArtistDto> getArtistBySong(Long id);

    SongDto updateSong(Long id,SongDto songDto);

    SongDto deleteSong(Long id);
}
