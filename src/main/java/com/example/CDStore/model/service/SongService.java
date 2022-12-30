package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.ClientDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.Client;
import com.example.CDStore.model.entity.Song;
import com.example.CDStore.repository.ISongRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService implements ISongService {

    private ISongRepository songRepository;

    private ModelMapper mapper;

    SongService(ISongRepository songRepository,ModelMapper mapper){
        this.songRepository=songRepository;
        this.mapper=mapper;
    }

    @Override
    public SongDto createSong(SongDto songDto) {
        Song song= new Song(songDto.getTitle(),songDto.getPrice(),songDto.getDuration());
        songRepository.save(song);
        return songDto;
    }


    @Override
    public List<SongDto> getAllSongs() {
        return songRepository.findAllSong().stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongsByTitle(String title) {
        List<Song> songs=songRepository.findSongByTitle(title);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongByPrice(double price) {
        List<Song> songs=songRepository.findSongByPrice(price);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongByPriceLowerThan(double price) {
        List<Song> songs=songRepository.findSongByPriceLowerThan(price);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongByPriceHigherThan(double price) {
        List<Song> songs=songRepository.findSongByPriceHigherThan(price);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongByDuration(double duration) {
        List<Song> songs=songRepository.findSongByDuration(duration);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<ArtistDto> getArtistBySong(Long id) {
        List<Artist> artists=songRepository.findArtistBySongId(id);
        return artists.stream().map(artist->mapper.map(artist,ArtistDto.class)).collect(Collectors.toList());
    }

    @Override
    public SongDto updateSong(Long id,SongDto songDto) {
        songRepository.updateSong(id,songDto.getTitle(),songDto.getPrice(),songDto.getDuration());
        return songDto;
    }

    @Override
    public SongDto deleteSong(Long id) {
        Song song=songRepository.findSongById(id);
        songRepository.delSong(id);
        SongDto songDto=mapper.map(song,SongDto.class);
        return songDto;
    }

}
